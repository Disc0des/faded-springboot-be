package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.AllClientNames;
import com.fadedink.fadedspringbootbe.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients/{id}")
    public @ResponseBody Optional<Client> client(@PathVariable int id){
        return clientRepository.findById(id);
    }

    @GetMapping("/clients")
    public @ResponseBody List<AllClientNames> getAllClients() {
        List<AllClientNames> clients = clientRepository.getAllClients();
        return clients;
    }

    @PostMapping("/clients")
    public @ResponseBody String addClients(@RequestBody Client client)
    {
        clientRepository.save(client);
        return "Client created successfully";
    }

    @DeleteMapping("/clients/{id}")
    public @ResponseBody String removeClient(@PathVariable int id)
    {
        clientRepository.deleteById(id);
        return "Client removed successfully";
    }
    @PutMapping("/clients")
    public @ResponseBody String updateClient(@RequestBody Client client)
    {
        Client updateClient = clientRepository.findById(client.id).orElseThrow(() -> new ResourceNotFoundException("Client not exist with id: " + client.id));;
        updateClient.setName(client.name);
        updateClient.setSurname(client.surname);
        updateClient.setContactNumber(client.contactNumber);
        updateClient.setTattooDescription(client.tattooDescription);
        updateClient.setNotes(client.notes);
        clientRepository.save(updateClient);
        return "Client details updated";
    }
}
