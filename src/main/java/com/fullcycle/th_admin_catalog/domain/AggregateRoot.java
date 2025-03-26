package com.fullcycle.th_admin_catalog.domain;


import com.fullcycle.th_admin_catalog.domain.validation.ValidationHandler;

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }

//    protected AggregateRoot(final ID id, final List<DomainEvent> events) {
//        super(id, events);
//    }
}
