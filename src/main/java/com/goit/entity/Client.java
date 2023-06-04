package com.goit.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Table(name = "client")
@Entity
@Data
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column
    @Size (min = 3, max = 200)
    private String name;
}
