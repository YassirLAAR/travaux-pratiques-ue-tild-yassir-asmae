package org.tsaap.competencies

import org.tsaap.competencies.repositories.CatalogRepository
import spock.lang.Specification


/**
 * Test competence service
 */
class CompetenceServiceTest extends Specification {


    private CompetenceService competenceService
    private CatalogRepository catalogRepository

    void setup() {
        catalogRepository = Mock(CatalogRepository)
        competenceService = new CompetenceService(catalogRepository)
    }

    def "test save a valid catalog"() {
        given: "a  catalog"
        def catalog = Mock(Catalog)

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "catalogRepositpory save is triggered"
        1 * catalogRepository.save(catalog)
    }


}
