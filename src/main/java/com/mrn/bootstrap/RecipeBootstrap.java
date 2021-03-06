package com.mrn.bootstrap;

import com.mrn.domain.*;
import com.mrn.repositories.CategoryRepository;
import com.mrn.repositories.RecipeRepository;
import com.mrn.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
                                                                UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // save the recipe list
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        // Get uOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if(!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found!");
        }

        // get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        // Get categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found!");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");

        if(!italianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found!");
        }


//        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
//
//        if(!mexicanCategoryOptional.isPresent()) {
//            throw new RuntimeException("Expected Category Not Found!");
//        }
//
//
//        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
//
//        if(!fastFoodCategoryOptional.isPresent()) {
//            throw new RuntimeException("Expected Category Not Found!");
//        }

        //
        Category americanCategory = americanCategoryOptional.get();
        Category italianCateogry = italianCategoryOptional.get();


        // YUMMY Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("All you really need to make guacamole is ripe avocados and salt." +
                " After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. " +
                "Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" + "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. " +
                "You can get creative with homemade guacamole!");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. " +
                "Not ripe enough and the avocado will be hard and tasteless." +
                " Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado." +
                " If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. " +
                "If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");

        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(.5), teaSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Fresh lime or lemon juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seds removed, minced", new BigDecimal(2), eachUom));
        guacRecipe.getIngredients().add(new Ingredient("asdsd", new BigDecimal(2), dashUom));
        guacRecipe.getIngredients().add(new Ingredient("ffff", new BigDecimal(.5), eachUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(italianCateogry);

        // add recipe list
        recipes.add(guacRecipe);


        // YUMMY Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("Step 1 Heat taco shells as directed on box. " +
                "Step 2 In 10-inch nonstick skillet, cook beef over medium-high heat 5 to 7 minutes, stirring frequently, until thoroughly cooked; drain." +
                " Stir in water and taco seasoning mix; heat to boiling." +
                " Reduce heat; simmer uncovered 3 to 4 minutes, stirring frequently, until thickened. Step 3 Spoon beef into taco shells.");

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("Step 1 Heat taco shells as directed on box. Step 2 In 10-inch nonstick skillet, cook beef over medium-high heat 5 to 7 minutes, stirring frequently, until thoroughly cooked; drain. Stir in water and taco seasoning mix; heat to boiling. " +
                "Reduce heat; simmer uncovered 3 to 4 minutes, stirring frequently, until thickened. Step 3 Spoon beef into taco shells.");

        // add notes to recipe
        tacosNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacosNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Ancho Chilli Powder", new BigDecimal(2), tableSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Clove of garlic, choppedr", new BigDecimal(1), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("finely grate orange zestr", new BigDecimal(1), tableSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoonUom));

        // add tacos recipe to the list
        recipes.add(tacosRecipe);

        // return all recipes
        return recipes;

    }


}
