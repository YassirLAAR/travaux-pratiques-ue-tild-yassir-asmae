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

}
