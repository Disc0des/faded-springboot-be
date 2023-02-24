package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class ShortClient {
    @Id
    Integer id;
    @Column
    String name;
    @Column
    String surname;
}
