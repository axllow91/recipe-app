package com.mrn.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    /*
     * When writing tests, it is common to find that several tests need similar objects created before they can run.
     * Annotating a public void method with @Before causes that method to be run before the Test method.
     * The @Before methods of superclasses will be run before those of the current class,
     * unless they are overridden in the current class.
     * No other ordering is defined.
     *
     * */
    // This will create new object before every test will be executed
    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}