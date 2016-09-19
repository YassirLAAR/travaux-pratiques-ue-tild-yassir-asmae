package org.tsaap.competencies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tsaap.competencies.Catalog;

/**
 * Catalog repository
 */
public interface CatalogRepository extends CrudRepository<Catalog,Long> {
}
