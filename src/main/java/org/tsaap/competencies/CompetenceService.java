package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;
import org.tsaap.competencies.repositories.CategoryRepository;
import org.tsaap.competencies.repositories.CompetenceRepository;

import java.util.List;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    public CompetenceService(CatalogRepository catalogRepository, CategoryRepository categoryRepository, CompetenceRepository competenceRepository) {
        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository;
        this.competenceRepository = competenceRepository;
        init();
    }

    public CompetenceService(){
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setCompetenceRepository(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public void init (){
        Catalog  catalog = new Catalog();
        catalog.setDescription("Desc1");
        catalog.setName("cat1");
        catalogRepository.save(catalog);

        Category category=new Category();
        category.setDescription("Desc2");
        category.setName("categ1");
        categoryRepository.save(category);

        Competence competence = new Competence();
        competence.setDescription("Desc3");
        competence.setName("compt");
        competence.setCatalog(catalog);
        competence.setCategory(category);
        competenceRepository.save(competence);

        Competence competence2 = new Competence();
        competence2.setDescription("Desc4");
        competence2.setName("compt2");
        competence2.setCatalog(catalog);
        competence2.setCategory(category);
        saveCompetence(competence2);
    }

    public List <Competence> findAllCompetences(){
        return (List<Competence>) competenceRepository.findAll();
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
     * Save category in the database
     * @param category the category to save
     * @return the category
     */
    public Category saveCategory(Category category) {
        Category res =  categoryRepository.save(category);
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

}
