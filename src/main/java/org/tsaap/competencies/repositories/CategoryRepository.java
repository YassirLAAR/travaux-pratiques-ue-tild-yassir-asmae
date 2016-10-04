package org.tsaap.competencies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tsaap.competencies.Catalog;
import org.tsaap.competencies.Category;

/**
 * Catalog repository
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
