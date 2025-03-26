package com.fullcycle.th_admin_catalog.domain.category;

import com.fullcycle.th_admin_catalog.pagination.Pagination;
import com.fullcycle.th_admin_catalog.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface CategoryGateway {
    Category create(Category category);

    void deleteById(CategoryID id);

    Optional<Category> findById(CategoryID id);

    Category update(Category category);

    Pagination<Category> findAll(SearchQuery query);

    List<CategoryID> existsByIds(Iterable<CategoryID> ids);
}
