package com.abhinav.ipldashboard.controller;

import java.io.IOException;
import java.util.List;

import com.abhinav.ipldashboard.entity.MatchModel;
import com.abhinav.ipldashboard.helper.CSVHelper;
import com.abhinav.ipldashboard.message.ResponseMessage;
import com.abhinav.ipldashboard.service.CSVService;
import com.abhinav.ipldashboard.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/api/csv")
@CrossOrigin(origins = "http://localhost:8080") // Adjust the origin based on your frontend application
public class CSVController {

    @Autowired
    private CSVService csvFileService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                csvFileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();


                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a CSV file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @PostMapping("/kafkapush")
    public ResponseEntity<ResponseMessage> pushToKafka(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                // Convert CSV data to a list of MatchModel objects
                List<MatchModel> modelList = CSVHelper.csvToMatches(file.getInputStream());

                // Push the list of model objects to Kafka
                kafkaProducerService.sendToKafka(modelList);

                message = "Pushed the file data to Kafka successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not push the file data to Kafka: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a CSV file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


    @GetMapping("/getAllMatches")
    public ResponseEntity<List<MatchModel>> getAllMatches() {
        try {
            List<MatchModel> matches = csvFileService.getAllMatches();

            if (matches.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
