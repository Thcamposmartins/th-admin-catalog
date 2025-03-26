package com.fullcycle.th_admin_catalog.domain.category;

import com.fullcycle.th_admin_catalog.domain.Identifier;
import java.util.Objects;

public class CategoryID extends Identifier {
    private final String value;

    private CategoryID(final String value) {
        this.value = Objects.requireNonNull(value);
    }
    public static CategoryID uniqueID() {
        return new CategoryID(java.util.UUID.randomUUID().toString());
    }

    public static CategoryID from(final String value) {
        return new CategoryID(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
