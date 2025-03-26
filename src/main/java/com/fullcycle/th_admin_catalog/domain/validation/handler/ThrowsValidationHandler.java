package com.fullcycle.th_admin_catalog.domain.validation.handler;

import com.fullcycle.th_admin_catalog.domain.exceptions.DomainException;
import com.fullcycle.th_admin_catalog.domain.validation.ValidationHandler;
import com.fullcycle.th_admin_catalog.domain.validation.Error;


import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error error) {
        throw DomainException.with(error);
    }

    @Override
    public ValidationHandler append(final ValidationHandler handler) {
        throw DomainException.with(handler.getErrors());
    }

    @Override
    public <T> T validate(final Validation<T> validation) {
        try {
            return validation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new Error(ex.getMessage()));
        }
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
