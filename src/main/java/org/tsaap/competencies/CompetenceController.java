package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Armstrong on 10/23/2016.
 */
@RestController
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @RequestMapping(value = "/competences")
    public List<Competence> allCompetences() {
        return competenceService.findAllCompetences();
    }
}
