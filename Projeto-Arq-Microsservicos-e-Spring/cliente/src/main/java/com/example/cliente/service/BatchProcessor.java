package com.example.cliente.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchProcessor {

    private final List<String> messageBatch = new ArrayList<>();
    private static final int BATCH_SIZE = 10;  // Tamanho do lote

    @RabbitListener(queues = "batchQueue")
    public void receiveBatchMessage(String message) {
        messageBatch.add(message);
        System.out.println("Mensagem recebida: " + message);
        
        if (messageBatch.size() >= BATCH_SIZE) {
            processBatch();
            messageBatch.clear();  // Limpa o lote após o processamento
        }
    }

    public void processBatch() {
        System.out.println("Processando lote de mensagens: " + messageBatch);
        // Implementar aqui a lógica do processamento do lote
    }
}
