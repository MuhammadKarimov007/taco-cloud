package com.taco.tacocloud.controller;

import com.taco.tacocloud.entity.Ingredient;
import com.taco.tacocloud.entity.Taco;
import com.taco.tacocloud.entity.TacoOrder;
import com.taco.tacocloud.entity.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DesignController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredientList = new ArrayList<>(List.of(
                new Ingredient("AA", "Tomato", Type.VEGGIES),
                new Ingredient("AB", "Cucumber", Type.VEGGIES),
                new Ingredient("BA", "Holland", Type.CHEESE),
                new Ingredient("BB", "Cream", Type.CHEESE),
                new Ingredient("CA", "Cabbage", Type.WRAP),
                new Ingredient("CB", "Bread", Type.WRAP),
                new Ingredient("DA", "Pepper", Type.SAUCE),
                new Ingredient("DB", "Salsa", Type.SAUCE),
                new Ingredient("EA", "Meat", Type.PROTEIN),
                new Ingredient("EB", "Sheep", Type.PROTEIN)
        ));

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterIngredients(ingredientList, type));
        }
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }

    @PostMapping
    public String processDesign(Taco taco,
                                @ModelAttribute TacoOrder order) {
        order.addTaco(taco);

        return "redirect:/orders/current";
    }


    private List<Ingredient> filterIngredients(List<Ingredient> ingredientList, Type type) {
        return ingredientList.stream()
                .filter(ingredient -> ingredient.type().equals(type))
                .collect(Collectors.toList());
    }

}
