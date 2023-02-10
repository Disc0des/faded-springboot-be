package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientsController {

    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/clients")
    public @ResponseBody Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping("/clients")
    public @ResponseBody String addClients(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String contactNumber)
    {
        Client newClient = new Client();
        newClient.setName(name);
        newClient.setSurname(surname);
        newClient.setContactNumber(contactNumber);
        clientRepository.save(newClient);
        return "Client created successfully";
    }

    @DeleteMapping("/clients")
    public @ResponseBody String removeClient(@RequestParam int id)
    {
        clientRepository.deleteById(id);
        return "Client removed successfully";
    }

    @PutMapping("/clients")
    public @ResponseBody String updateClient(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String contactNumber) {
        Client updateClient = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not exist with id: " + id));;
        updateClient.setName(name);
        updateClient.setSurname(surname);
        updateClient.setContactNumber(contactNumber);
        clientRepository.save(updateClient);
        return "Client details updated";
    }
}
