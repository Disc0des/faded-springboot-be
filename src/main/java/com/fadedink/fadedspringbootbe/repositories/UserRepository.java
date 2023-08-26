package com.fadedink.fadedspringbootbe.repositories;
import com.fadedink.fadedspringbootbe.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT COUNT(*) FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    int validateLogin(String username, String password);
}