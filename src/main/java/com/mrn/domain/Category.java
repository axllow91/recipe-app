package com.mrn.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/*
* Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
* Will also generate setters for all non-final fields, as well as a constructor.
* Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
* */
@Data // -> project lombok annotation
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {
//
//    @ManyToMany
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
