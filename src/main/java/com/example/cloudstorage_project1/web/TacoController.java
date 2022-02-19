package com.example.cloudstorage_project1.web;

import com.example.cloudstorage_project1.domain.Ingredient;
import com.example.cloudstorage_project1.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class TacoController {


    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.IngredientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.IngredientType.SAUCE)
        );
        Ingredient.IngredientType[] types = Ingredient.IngredientType.values();
        for (Ingredient.IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByIngredientType(ingredients, type));
        }
    }
    @GetMapping
    public String showDesignForm(Model model){
        model.addAttribute("taco", new Taco());
        return "design";
    }

    public Iterable<Ingredient> filterByIngredientType(List<Ingredient> ingredients, Ingredient.IngredientType type){
       return ingredients.stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }


}
