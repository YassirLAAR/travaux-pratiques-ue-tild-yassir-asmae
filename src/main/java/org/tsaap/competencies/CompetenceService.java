package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;

    public CompetenceService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository ;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
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

}
