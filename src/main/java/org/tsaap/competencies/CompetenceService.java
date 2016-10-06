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

<<<<<<< HEAD
        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository ;
        this.competenceRepository=competenceRepository;
=======
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    public CompetenceService(CatalogRepository catalogRepository, CategoryRepository categoryRepository, CompetenceRepository competenceRepository) {
        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository;
        this.competenceRepository = competenceRepository;
>>>>>>> 213e0bd35429507fa27f8b2b1d32aedecf175c59
    }

    public CompetenceService(){}

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

<<<<<<< HEAD
    public void setCompetenceRepository(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
=======
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setCompetenceRepository(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

>>>>>>> 213e0bd35429507fa27f8b2b1d32aedecf175c59
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
<<<<<<< HEAD
     * Save competence in the database
     * @param competence the competence to save
     * @return the competence
     */
    public Competence saveCompetence(Competence competence) {
        Competence res =  competenceRepository.save(competence);
        return res;
    }
    /**
=======
>>>>>>> 213e0bd35429507fa27f8b2b1d32aedecf175c59
     * Save category in the database
     * @param category the category to save
     * @return the category
     */
    public Category saveCategory(Category category) {
        Category res =  categoryRepository.save(category);
        return res;
    }
<<<<<<< HEAD
=======
    /**
     * Save competence in the database
     * @param competence the competence to save
     * @return the competence
     */
    public Competence saveCompetence(Competence competence) {
        Competence res =  competenceRepository.save(competence);
        return res;
    }

>>>>>>> 213e0bd35429507fa27f8b2b1d32aedecf175c59
}
