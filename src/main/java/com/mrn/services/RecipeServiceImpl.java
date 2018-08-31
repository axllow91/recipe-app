package com.mrn.services;

import com.mrn.domain.Recipe;
import com.mrn.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j // -> lombok annotation: this @SLf4j will give us a logger
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

        log.debug("I'm in the service recipe implementation");

        Set<Recipe> recipes = new HashSet<>();
        // find all by iterating each of and add it to the set
        // this is a cool java 8 implementation
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()) throw new RuntimeException("Recipe not Found!");

        return recipeOptional.get();
    }

}
