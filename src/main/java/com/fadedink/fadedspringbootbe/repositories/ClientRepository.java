package com.fadedink.fadedspringbootbe.repositories;
import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.entities.ShortClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query(value = "SELECT id, name, surname FROM client", nativeQuery = true)
    List<AllClientNames> getAllClients();
}


