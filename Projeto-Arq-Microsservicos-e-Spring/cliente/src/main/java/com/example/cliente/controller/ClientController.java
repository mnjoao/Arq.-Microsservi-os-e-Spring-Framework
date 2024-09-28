package com.example.cliente.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import com.example.cliente.model.Client;
import com.example.cliente.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/with-products")
    public String getClientsWithProducts() {
    // Chamada ao service-produtos usando o nome do serviço registrado no Eureka
    String responseFromServiceProduct = restTemplate.getForObject("http://service-produto/products", String.class);
    return "Clients and products: " + responseFromServiceProduct;
}

}