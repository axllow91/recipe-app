package com.mrn.services;

import com.mrn.domain.Recipe;
import com.mrn.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{
    // Instance of repository
    private final RecipeRepository recipeRepository;


    // Repository recipe is injected through out the constructor
    // best practice to inject
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> recipes = new HashSet<>();
        // find all by iterating each of and add it to the set
        // this is a cool java 8 implementation
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
