package org.tsaap.competencies

import org.tsaap.competencies.repositories.*
import spock.lang.Specification


/**
 * Test competence service
 */
class CompetenceServiceTest extends Specification {


    private CompetenceService competenceService
    private CatalogRepository catalogRepository
    private CategoryRepository categoryRepository
    private CompetenceRepository competenceRepository

    void setup() {
        catalogRepository = Mock(CatalogRepository)
        categoryRepository = Mock(CategoryRepository)
        competenceRepository = Mock(CompetenceRepository)
        competenceService = new CompetenceService(catalogRepository, categoryRepository,competenceRepository)
    }

    def "test save a valid catalog"() {
        given: "a  catalog"
        def catalog = Mock(Catalog)

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "catalogRepositpory save is triggered"
        1 * catalogRepository.save(catalog)
    }

    def "test save a valid category"() {
        given: "a  category"
        def category = Mock(Category)

        when: "the category is saved"
        competenceService.saveCategory(category);

        then: "categoryRepositpory save is triggered"
        1 * categoryRepository.save(category)
    }

    def "test save a valid competence"() {
        given: "a  competence"
        def competence = Mock(Competence)

        when: "the competence is saved"
        competenceService.saveCompetence(competence);

        then: "competenceRepositpory save is triggered"
        1 * competenceRepository.save(competence)
    }

}
