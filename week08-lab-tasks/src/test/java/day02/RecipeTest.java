package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe recipe;

    @Test
    void testCreateRecipeOneParameter() {
        recipe = new Recipe("Rántott leves");
        assertEquals("Rántott leves", recipe.getName());
        assertNull(recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testCreateRecipeTwoParameters() {
        recipe = new Recipe("Somlói galuska", "Nincs többé elrontott piskóta!");
        assertEquals("Somlói galuska", recipe.getName());
        assertEquals("Nincs többé elrontott piskóta!", recipe.getDescription());
    }

    @Test
    void testAddIngredients() {
        recipe = new Recipe("Rántott leves");
        recipe.addIngredient("víz");
        recipe.addIngredient("liszt", "olaj", "só");
        recipe.addIngredient("tojás", new String[]{"pirospaprika", "őrölt kömény"});
        List<String> expected = Arrays.asList("víz", "liszt", "olaj", "só", "tojás", "pirospaprika", "őrölt kömény");
        List<String> actual = recipe.getIngredients();
        assertEquals(expected, actual);
    }
}