package com.fadedink.fadedspringbootbe.controllers;
import com.fadedink.fadedspringbootbe.ShortClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ClientsSummaryController {
    List<ShortClient> shortClientsList = new ArrayList(List.of(
            new ShortClient(1, "short", "client"),
            new ShortClient(2, "another", "shorty")
    ));

    @GetMapping("/clients-summary")
    public List getShortClients(){
        return shortClientsList;
    }
}
