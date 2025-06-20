package org.example.exo5spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Furniture {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @NotBlank
    @NotNull
private String name;

    @NotBlank
    @NotNull
private String description;


    @NotNull
private double price;


    @NotNull
private Long stock;






}
