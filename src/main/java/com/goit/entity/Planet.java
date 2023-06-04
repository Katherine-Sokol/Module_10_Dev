package com.goit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Table(name = "planet")
@Entity
@Data
public class Planet {

    @Id
    @Pattern(regexp = "\\b[A-Z0-9]+\\b")
    private String id;

    @Column
    @Size(min = 1, max = 500)
    private String name;
}
