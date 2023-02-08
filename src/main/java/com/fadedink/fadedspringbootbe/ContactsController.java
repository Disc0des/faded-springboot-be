package com.fadedink.fadedspringbootbe;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ContactsController {
    List<Contact> contactsList = new ArrayList(List.of(
        new Contact(1, "black", "panther", "0777775"),
        new Contact(2, "captain", "america", "0888854")
    ));


    @GetMapping("/contacts")
    public List greeting() {
        return contactsList;
    }

    @PostMapping("/contacts")
    public List contacts(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String contactNumber){
        Contact newContact = new Contact(id, name, surname, contactNumber);
        contactsList.add(newContact);
        return contactsList;
    }

    @DeleteMapping("/contacts")
    public List contacts(@RequestParam int id){
        contactsList.removeIf(element -> (element.id == id));
        return contactsList;
    }
}
