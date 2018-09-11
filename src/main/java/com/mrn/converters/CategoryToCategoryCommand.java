package com.mrn.converters;

import com.mrn.commands.CategoryCommand;
import com.mrn.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*
Converter interface -> A converter converts a source object of type S to a target of type T.
Implementations of this interface are thread-safe and can be shared.
Implementations may additionally implement ConditionalConverter.
Type Parameters:
S - the source type
T - the target type
*/
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {

        if(source == null)
            return null;

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
