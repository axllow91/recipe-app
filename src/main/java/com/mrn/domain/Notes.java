package com.mrn.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = {"recipe"})
@EqualsAndHashCode(exclude = {"recipe"})
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

    public Notes() {
    }
}
