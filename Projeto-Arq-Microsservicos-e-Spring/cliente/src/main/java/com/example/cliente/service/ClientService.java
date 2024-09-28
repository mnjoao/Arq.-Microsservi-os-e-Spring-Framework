package com.example.cliente.service;


import java.util.List;
import java.util.ArrayList;
import com.example.cliente.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private List<Client> clients = new ArrayList<>();

    public List<Client> getAllClients() {
        return clients;
    }

    public Client getClientById(Long id) {
        return clients.stream().filter(client -> client.getId().equals(id)).findFirst().orElse(null);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void updateClient(Long id, Client updatedClient) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getId().equals(id)) {
                clients.set(i, updatedClient);
                return;
            }
        }
    }

    public void deleteClient(Long id) {
        clients.removeIf(client -> client.getId().equals(id));
    }
}