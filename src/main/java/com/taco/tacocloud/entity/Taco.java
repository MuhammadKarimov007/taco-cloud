package com.taco.tacocloud.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco  {
    private Long id;
    private Date createdAt = new Date();

    @NotEmpty(message = "Name can''t be empty")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;


    @NotEmpty(message = "You must choose at least one ingredient")
    @Size(min = 1, message = "You must choose at least one ingredient from the list")
    private List<Ingredient> ingredients;
}
