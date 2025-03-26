package com.fullcycle.th_admin_catalog.domain.category;

import com.fullcycle.th_admin_catalog.domain.AggregateRoot;
import com.fullcycle.th_admin_catalog.domain.validation.ValidationHandler;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Setter
@Getter
public class Category extends AggregateRoot<CategoryID> {

    public String name;
    public String description;
    public boolean active;
    public Instant createdAt;
    public Instant updatedAt;
    public Instant deletedAt;

    private Category(final CategoryID id, final String name, final String description, final boolean active, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        super(id);
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }


    public static Category newCategory(final String name, final String description, final boolean active) {
        final var id = CategoryID.uniqueID();
        return new Category(id, name, description, active, Instant.now(), Instant.now(), null);
    }
    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public Category activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = Instant.now();
        }

        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category update(
            final String aName,
            final String aDescription,
            final boolean isActive
    ) {
        if (isActive) {
            activate();
        } else {
            deactivate();
        }
        this.name = aName;
        this.description = aDescription;
        this.updatedAt = Instant.now();
        return this;
    }
}


