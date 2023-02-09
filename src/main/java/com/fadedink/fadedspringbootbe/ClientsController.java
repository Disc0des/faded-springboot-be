package com.fadedink.fadedspringbootbe;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientsController {

    List<Client> clientsList = new ArrayList(List.of(
        new Client(1, "black", "panther", "0777775"),
        new Client(2, "captain", "america", "0888854")
    ));

    @GetMapping("/clients")
    public List getClients() {
        return clientsList;
    }

    @PostMapping("/clients")
    public List addClients(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String contactNumber){
        Client newClient = new Client(id, name, surname, contactNumber);
        clientsList.add(newClient);
        return clientsList;
    }

    @DeleteMapping("/clients")
    public List deleteClient(@RequestParam int id){
        clientsList.removeIf(element -> (element.id == id));
        Client c = null;
        return clientsList;
    }

    @PutMapping("/clients")
    public List updateClient(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String contactNumber) {
        Client client = clientsList.get(0);
        client.name = name;
        client.surname = surname;
        client.contactNumber = contactNumber;
        return clientsList;
    }
}
