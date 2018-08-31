package com.mrn.repositories;

import com.mrn.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/*
 * When a class is annotated with @RunWith or extends a class annotated with @RunWith,
 * JUnit will invoke the class it references to run the tests in that class instead of the runner built into JUnit.
 * We added this feature late in development. While it seems powerful we expect the runner API to change as we learn how people really use it.
 * Some of the classes that are currently internal will likely be refined and become public
 * */
@RunWith(SpringRunner.class)
/*
 * Annotation that can be used in combination with @RunWith(SpringRunner.class)
 * for a typical JPA test. Can be used when a test focuses only on JPA components.
 * Using this annotation will disable full auto-configuration and instead apply only configuration relevant to JPA tests.
 * By default, tests annotated with @DataJpaTest will use an embedded in-memory database (replacing any explicit or usually auto-configured DataSource).
 * The @AutoConfigureTestDatabase annotation can be used to override these settings.
 * If you are looking to load your full application configuration, but use an embedded database,
 * you should consider @SpringBootTest combined with @AutoConfigureTestDatabase rather than this annotation.
 * */
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> unitofMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", unitofMeasure.get().getDescription());
//        assertEquals("Teaspoonssss", unitofMeasure.get().getDescription()); -- fails
    }

    @Test
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> unitofMeasure = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", unitofMeasure.get().getDescription());

    }
}