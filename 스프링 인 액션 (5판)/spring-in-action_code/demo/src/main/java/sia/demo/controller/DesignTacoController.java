package sia.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.demo.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import sia.demo.domain.Ingredient;

import javax.validation.Valid;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @GetMapping
    public String showDesignForm(@ModelAttribute("ingredient") Ingredient ingredient, Model model) {
        /*List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Corn2 Tortilla", Ingredient.Type.WRAP),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.WRAP)
        );*/

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> {
            System.out.println(i);
            ingredients.add(i);
        });

        IngredientType[] types = IngredientType.values();
        for (IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("ingredients", ingredients);
        model.addAttribute("taco", new Taco());
        
        return "home";
    }

    @PostMapping
    public String test(@ModelAttribute("ingredient") @Valid Ingredient ingredient, Errors errors, Model model){
        System.out.println("+++++++++++++++++++++++++");
        System.out.println(ingredient);
        if(errors.hasErrors()){
            System.out.println(errors.getFieldError().getField());
            System.out.println(errors.getFieldError().getDefaultMessage());
            return "home";
        }

        ingredientRepository.save(ingredient);

        System.out.println("no error");
        return "redirect:/design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
