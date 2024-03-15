package com.abhinav.ipldashboard.service;

import com.abhinav.ipldashboard.entity.MatchModel;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Service
public class KafkaConsumerService {
    private AtomicInteger counter = new AtomicInteger(0);

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory",topics = "ipl", groupId = "ipl-data")
    public void consume(MatchModel matchModel) {
        int matchNumber = counter.incrementAndGet();

        System.out.println("Received MatchModel: "+ matchNumber + ": " + matchModel);
    }
}
