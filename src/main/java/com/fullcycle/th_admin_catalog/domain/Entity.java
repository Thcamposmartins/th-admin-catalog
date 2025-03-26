package com.fullcycle.th_admin_catalog.domain;

import com.fullcycle.th_admin_catalog.domain.validation.ValidationHandler;
import lombok.Data;

import java.util.Objects;

@Data
public class Entity<ID extends Identifier> {

    protected final ID id;

    protected Entity(final ID id){
        Objects.requireNonNull(id,"Id cannot be null");
        this.id = id;
    }

    public void validate(ValidationHandler handler) {

    }

}
