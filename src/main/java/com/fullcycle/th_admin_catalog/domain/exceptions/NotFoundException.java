package com.fullcycle.th_admin_catalog.domain.exceptions;

import com.fullcycle.th_admin_catalog.domain.AggregateRoot;
import com.fullcycle.th_admin_catalog.domain.Identifier;
import com.fullcycle.th_admin_catalog.domain.validation.Error;


import java.util.Collections;
import java.util.List;

public class NotFoundException extends DomainException{
    protected NotFoundException(final String message, final List<Error> errors) {
        super(message, errors);
    }

    public static NotFoundException with(
            final Class<? extends AggregateRoot<?>> anAggregate,
            final Identifier id
    ) {
        final var anError = "%s with ID %s was not found".formatted(
                anAggregate.getSimpleName(),
                id.getValue()
        );
        return new NotFoundException(anError, Collections.emptyList());
    }

    public static NotFoundException with(final Error error) {
        return new NotFoundException(error.message(), List.of(error));
    }
}
