package com.abhinav.ipldashboard.service;

import com.abhinav.ipldashboard.entity.MatchModel;
import org.apache.kafka.clients.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.List;

@Service
public class KafkaProducerService {
    /*

    private static final String TOPIC_NAME = "ipl";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private KafkaProducer<String, MatchModel> producer;

    public KafkaProducerService() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.JavaSerializer");

        producer = new KafkaProducer<>(props);
    }

    public void sendToKafka(List<MatchModel> modelList) {
        try {
            for (MatchModel model : modelList) {
                ProducerRecord<String, MatchModel> record = new ProducerRecord<>(TOPIC_NAME, model);
                producer.send(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }


     */

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(List<MatchModel> matchModels) {
        for (MatchModel matchModel : matchModels) {
            kafkaTemplate.send("ipl", matchModel.getId(), String.valueOf(matchModel));
        }
    }
}
