package com.fadedink.fadedspringbootbe.repositories;
import com.fadedink.fadedspringbootbe.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
