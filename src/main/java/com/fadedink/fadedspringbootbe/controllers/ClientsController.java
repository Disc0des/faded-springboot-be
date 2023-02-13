package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients/{id}")
    public @ResponseBody Optional<Client> client(@PathVariable int id){
        return clientRepository.findById(id);
    }

    // TODO: this currently returns all fields for every client, we only need id, name, surname
    @GetMapping("/clients")
    public @ResponseBody Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping("/clients")
    public @ResponseBody String addClients(@RequestBody Client client)
    {
        clientRepository.save(client);
        return "Client created successfully";
    }

    @DeleteMapping("/clients")
    public @ResponseBody String removeClient(@RequestBody Client client)
    {
        clientRepository.deleteById(client.id);
        return "Client removed successfully";
    }

    @PutMapping("/clients")
    public @ResponseBody String updateClient(@RequestBody Client client)
    {
        Client updateClient = clientRepository.findById(client.id).orElseThrow(() -> new ResourceNotFoundException("Client not exist with id: " + client.id));;
        updateClient.setName(client.name);
        updateClient.setSurname(client.surname);
        updateClient.setContactNumber(client.contactNumber);
        clientRepository.save(updateClient);
        return "Client details updated";
    }
}
