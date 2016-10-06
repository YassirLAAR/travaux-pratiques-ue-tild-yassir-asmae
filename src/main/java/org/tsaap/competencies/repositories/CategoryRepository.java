package org.tsaap.competencies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.tsaap.competencies.Category;


/**
 * Created by Armstrong on 9/30/2016.
 */
public interface CategoryRepository  extends CrudRepository<Category,Long> {}
