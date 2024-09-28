package com.example.cliente.batch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchMessageProcessor {

    @RabbitListener(queues = "fila-mensagens", containerFactory = "batchFactory")
    public void processMessages(List<String> messages) {
        System.out.println("Processing batch of messages: " + messages);
        
    }
}