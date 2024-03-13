package com.abhinav.ipldashboard.service;

import com.abhinav.ipldashboard.entity.MatchModel;
import com.abhinav.ipldashboard.helper.CSVHelper;
import com.abhinav.ipldashboard.repository.MatchModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CSVService {

    @Autowired
    private MatchModelRepository matchModelRepository;
    // Assuming you have a repository for MatchModel

    public void save(MultipartFile file) {
        try {
            List<MatchModel> matches = CSVHelper.csvToMatches(file.getInputStream());

            matchModelRepository.saveAll(matches);

        } catch (IOException e) {
            throw new RuntimeException("Failed to save CSV data to database: " + e.getMessage());
        }
    }


    public List<MatchModel> getAllMatches() {
        return matchModelRepository.findAll();
    }


}
