package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;
import org.tsaap.competencies.repositories.CategoryRepository;
import org.tsaap.competencies.repositories.CompetenceRepository;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public CompetenceService(CatalogRepository catalogRepository,CompetenceRepository competenceRepository, CategoryRepository categoryRepository ) {

        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository ;
        this.competenceRepository=competenceRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void setCompetenceRepository(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    /**
     * Save catalog in the database
     * @param catalog the catalog to save
     * @return the catalog
     */
    public Catalog saveCatalog(Catalog catalog) {
        Catalog res =  catalogRepository.save(catalog);
        return res;
    }
    /**
     * Save competence in the database
     * @param competence the competence to save
     * @return the competence
     */
    public Competence saveCompetence(Competence competence) {
        Competence res =  competenceRepository.save(competence);
        return res;
    }
    /**
     * Save category in the database
     * @param category the category to save
     * @return the category
     */
    public Category saveCategory(Category category) {
        Category res =  categoryRepository.save(category);
        return res;
    }
}
