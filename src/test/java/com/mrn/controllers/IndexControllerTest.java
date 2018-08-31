package com.mrn.controllers;

import com.mrn.domain.Recipe;
import com.mrn.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    private IndexController indexController;

    @Mock
    Model model;

    @Mock
    private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }


    @Test
    public void testMockMvc() throws Exception {
        // this is a builder pattern so we need to call the build method
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/")).
                andExpect(status().isOk()).
                andExpect(view().name("index"));
    }

    @Test
    public void indexPage() throws Exception {

        // Given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        // create new recipe obj
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipes.add(recipe);


        when(recipeService.getRecipes()).thenReturn(recipes);

        // when
        String viewName = indexController.indexPage(model);

        assertEquals("index", viewName);

        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // then
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setIndexController = (Set<Recipe>) argumentCaptor.getValue();
        assertEquals(2, setIndexController.size());

    }
}