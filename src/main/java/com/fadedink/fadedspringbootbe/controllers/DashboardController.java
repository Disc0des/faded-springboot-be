package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.repositories.AllClientNames;
import com.fadedink.fadedspringbootbe.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/follow-up/{months}")
    public @ResponseBody List<Client> getClientsToFollowUp(@PathVariable int months) {
        List<Client> clients = clientRepository.getClientsToFollowUp(months);
        return clients;
    }
}
