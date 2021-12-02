package day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients = new ArrayList<>();
    private String description;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addIngredient(String ingredient, String... ingredients) {
        this.ingredients.add(ingredient);
        Collections.addAll(this.ingredients, ingredients);
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return List.copyOf(ingredients);
    }

    public String getDescription() {
        return description;
    }
}
