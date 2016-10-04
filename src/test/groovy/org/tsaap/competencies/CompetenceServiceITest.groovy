package org.tsaap.competencies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Test competence service
 */
@ContextConfiguration
@SpringBootTest
class CompetenceServiceITest extends Specification {

    @Autowired
    private CompetenceService competenceService

    def "test save a valid catalog"() {
        given: "a valid catalog"
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "the catalog has an id"
        catalog.getId() != null
        catalog.getName() == "Catalog 1"
        catalog.getDescription() == "Description 1"
    }

    def "test save a non valid catalog"() {
        given: "a non valid catalog"
        Catalog catalog = new Catalog();
        catalog.setName("C1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }

    def "test save a valid category"() {
        given: "a valid category"
        Category category = new Category();
        category.setId(15);
        category.setName("Category 1");
        category.setDescription("Description 1");

        when: "the category is saved"
        competenceService.saveCategory(category);

        then: "the category has an id"
        category.getId() == 15
        category.getName() == "Category 1"
        category.getDescription() == "Description 1"
    }

    def "test save a non valid category"() {
        given: "a non valid category"
        Category category = new Category();
        category.setName("C1");
        category.setDescription("Description 1");

        when: "the category is saved"
        competenceService.saveCategory(category);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }

    def "test save a valid competence"() {
        given: "a valid competence"
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 2");
        catalog.setDescription("Description 2");

        Category category = new Category();
        category.setId(17);
        category.setName("Category 2");
        category.setDescription("Description 2");

        Competence competence = new Competence();
        competence.setId(1);
        competence.setName("Competence 1");
        competence.setDescription("Description 1");
        competence.setCatalog(catalog);
        competence.setCategory(category);

        when: "the competence is saved"
        competenceService.saveCompetence(competence);

        then: "the competence has an id"
        competence.getId() == 1
        competence.getName() == "Competence 1"
        competence.getDescription() == "Description 1"
        competence.getCatalog().equals(catalog) == true
        competence.getCategory().equals(category) == true

    }

    def "test save a non valid competence"() {
        given: "a non valid competence"
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
        competenceService.saveCompetence(competence);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }
}
