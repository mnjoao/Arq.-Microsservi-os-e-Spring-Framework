package com.example.cliente.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "productQueue")  // Fila para consumir mensagens
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
        
    }
}