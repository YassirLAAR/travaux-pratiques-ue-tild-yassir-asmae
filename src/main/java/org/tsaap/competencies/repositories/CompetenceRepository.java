package org.tsaap.competencies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tsaap.competencies.Competence;

/**
 * Catalog repository
 */
public interface CompetenceRepository extends CrudRepository<Competence,Long> {
}
