package com.mrn.repositories;

import com.mrn.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    /*
    * A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true.
    * If no value is present, the object is considered empty and isPresent() returns false.
    * Additional methods that depend on the presence or absence of a contained value are provided, such as orElse()
    * (returns a default value if no value is present) and ifPresent() (performs an action if a value is present).
    * */
    Optional<Category> findByDescription(String description);
}
