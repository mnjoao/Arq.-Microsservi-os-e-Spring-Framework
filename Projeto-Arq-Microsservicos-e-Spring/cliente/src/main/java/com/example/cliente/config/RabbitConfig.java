package com.example.cliente.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public SimpleRabbitListenerContainerFactory batchFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setBatchListener(true);  // Ativa o processamento em lote
        factory.setConsumerBatchEnabled(true);
        factory.setBatchSize(10);  // Define o tamanho do lote (10 mensagens)
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
