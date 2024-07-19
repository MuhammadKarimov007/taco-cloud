package com.taco.tacocloud.entity;


import lombok.Getter;

import java.util.List;

@Getter
public class Taco {
    private String name;
    private List<Ingredient> ingredients;

    public Taco() {
    }

    public Taco(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
