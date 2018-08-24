package com.mrn.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

  /*
    Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
    Portable applications should use the Lob annotation when mapping to a database Lob type.
    The Lob annotation may be used in conjunction with the Basic annotation or the
    ElementCollection annotation when the element collection value is of basic type
 */
    @Lob
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
