package com.synchrony.main.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishImageEvent(String username, String imageName) {
        String message = "User: " + username + " uploaded image: " + imageName;
        kafkaTemplate.send("image-events", username, message);
    }
}
