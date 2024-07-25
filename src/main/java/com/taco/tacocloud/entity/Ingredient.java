package com.taco.tacocloud.entity;

import lombok.Data;

public record Ingredient(String id, String name, Type type) {
}
