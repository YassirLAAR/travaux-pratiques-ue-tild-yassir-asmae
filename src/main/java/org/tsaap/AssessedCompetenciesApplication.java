package org.tsaap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tsaap.competencies.CompetenceService;

@SpringBootApplication
public class AssessedCompetenciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessedCompetenciesApplication.class, args);
	}
}
