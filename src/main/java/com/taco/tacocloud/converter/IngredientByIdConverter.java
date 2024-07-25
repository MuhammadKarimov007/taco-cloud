package com.taco.tacocloud.converter;

import com.taco.tacocloud.entity.Ingredient;
import com.taco.tacocloud.entity.Type;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final Map<String, Ingredient> map = new HashMap<>();

    public IngredientByIdConverter() {
        map.put("AA", new Ingredient("AA", "Tomato", Type.VEGGIES));
        map.put("AB", new Ingredient("AB", "Cucumber", Type.VEGGIES));
        map.put("BA", new Ingredient("BA", "Holland", Type.CHEESE));
        map.put("BB", new Ingredient("BB", "Cream", Type.CHEESE));
        map.put("CA", new Ingredient("CA", "Cabbage", Type.WRAP));
        map.put("CB", new Ingredient("CB", "Bread", Type.WRAP));
        map.put("DA", new Ingredient("DA", "Pepper", Type.SAUCE));
        map.put("DB", new Ingredient("DB", "Salsa", Type.SAUCE));
        map.put("EA", new Ingredient("EA", "Meat", Type.PROTEIN));
        map.put("EB", new Ingredient("EB", "Sheep", Type.PROTEIN));
    }

    @Override
    public Ingredient convert(String id) {
        return map.get(id);
    }
}
