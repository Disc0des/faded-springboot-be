package com.fadedink.fadedspringbootbe.repositories;
import com.fadedink.fadedspringbootbe.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Client, Integer> {
}