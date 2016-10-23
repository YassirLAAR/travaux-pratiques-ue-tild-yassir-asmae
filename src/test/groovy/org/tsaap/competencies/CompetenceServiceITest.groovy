package org.tsaap.competencies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.tsaap.competencies.repositories.CatalogRepository
import org.tsaap.competencies.repositories.CategoryRepository
import org.tsaap.competencies.repositories.CompetenceRepository
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Test competence service
 */
@ContextConfiguration
@SpringBootTest
class CompetenceServiceITest extends Specification {

    @Autowired
    private CatalogRepository catalogRepository
    @Autowired
    private CategoryRepository categoryRepository
    @Autowired
    private CompetenceRepository competenceRepository


    def "test save a valid catalog"() {
        given: "a valid catalog"
        CompetenceService competenceService = new CompetenceService();
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.setCatalogRepository(catalogRepository);
        competenceService.saveCatalog(catalog);

        then: "the catalog has an id"
        catalog.getId() != null
        catalog.getName() == "Catalog 1"
        catalog.getDescription() == "Description 1"
    }

    def "test save a non valid catalog"() {
        given: "a non valid catalog"
        CompetenceService competenceService = new CompetenceService();
        Catalog catalog = new Catalog();
        catalog.setName("C1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.setCatalogRepository(catalogRepository);
        competenceService.saveCatalog(catalog);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }

    def "test save a valid category"() {
        given: "a valid category"
        CompetenceService competenceService = new CompetenceService();
        Category category = new Category();
        category.setId(15);
        category.setName("Category 1");
        category.setDescription("Description 1");

        when: "the category is saved"
        competenceService.setCategoryRepository(categoryRepository);
        competenceService.saveCategory(category);

        then: "the category has an id"
        category.getId() != null
        category.getName() == "Category 1"
        category.getDescription() == "Description 1"
    }

    def "test save a non valid category"() {
        given: "a non valid category"
        CompetenceService competenceService = new CompetenceService();
        Category category = new Category();
        category.setName("C1");
        category.setDescription("Description 1");

        when: "the category is saved"
        competenceService.setCategoryRepository(categoryRepository);
        competenceService.saveCategory(category);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }

    def "test save a valid competence"() {
        given: "a valid competence"
        CompetenceService competenceService = new CompetenceService();
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 2");
        catalog.setDescription("Description 2");


        Category category = new Category();
        category.setId(1);
        category.setName("Category 2");
        category.setDescription("Description 2");


        Competence competence = new Competence();
        competence.setId(20);
        competence.setName("Competence 1");
        competence.setDescription("Description 1");
        competence.setCatalog(catalog);
        competence.setCategory(category);

        when: "the competence is saved"
        competenceService.setCatalogRepository(catalogRepository);
        competenceService.saveCatalog(catalog);
        competenceService.setCategoryRepository(categoryRepository);
        competenceService.saveCategory(category);
        competenceService.setCompetenceRepository(competenceRepository);
        competenceService.saveCompetence(competence);

        then: "the competence has an id"
        competence.getId() != null
        competence.getName() == "Competence 1"
        competence.getDescription() == "Description 1"
        competence.getCatalog().equals((Catalog)catalog) == true
        //competence.getCatalog().getId() != null
        //competence.getCatalog().getName() == "Catalog 2"
        //competence.getCatalog().getDescription() == "Description 2"
        competence.getCategory().equals((Category)category) == true
        //competence.getCategory().getId() != null
        //competence.getCategory().getName() == "Category 2"
        //competence.getCategory().getDescription() == "Description 2"
    }

    def "test save a non valid competence"() {
        given: "a non valid competence"
        CompetenceService competenceService = new CompetenceService();
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 2");
        catalog.setDescription("Description 2");


        Category category = new Category();
        category.setId(17);
        category.setName("Category 2");
        category.setDescription("Description 2");


        Competence competence = new Competence();
        competence.setName("C1");
        competence.setDescription("Description 1");
        competence.setCatalog(catalog);
        competence.setCategory(category);

        when: "the competence is saved"
        competenceService.setCatalogRepository(catalogRepository);
        competenceService.saveCatalog(catalog);
        competenceService.setCategoryRepository(categoryRepository);
        competenceService.saveCategory(category);
        competenceService.setCompetenceRepository(competenceRepository);
        competenceService.saveCompetence(competence);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }


    def "test findAll the competences"() {
        given: "save a competence"

        List <Competence> list = null

        CompetenceService competenceService = new CompetenceService(catalogRepository,categoryRepository,competenceRepository);


        when: "the competences are found"

        list = competenceService.findAllCompetences();

        then: "the list is not empty"
        list != null

    }

    def "test not findAll the competences"() {
        given: "save a competence"

        List <Competence> list = null

        CompetenceService competenceService = new CompetenceService(catalogRepository,categoryRepository,competenceRepository);


        when: "the competences are found"

        list = competenceService.findAllCompetences();

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException

    }
}
