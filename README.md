# Master iLORD - Tests et intégration de logiciels distribués 
 
## TP1 - Découverte de l'environnement de travail

### 1. Création d'un compte Github et récupération du projet "AssessedCompetencies"

- Rendez vous sur le plateforme Web [Github](https://github.com/) et créez un compte sur la plateforme.
- Rendez vous sur le devoir correspondant à nos [travaux pratiques](https://classroom.github.com/group-assignment-invitations/c40767b41493090001d29c1b93c8c4f3).
- *Clonez* le projet dans votre espace de travail en utilisant la commande *git clone https://..."*
- Créez la branche *develop* dans votre repository local et *pushez* la branche sur Github à l'aide de la commande suivante :
*"git push -u origin develop"* . 

### 2. Premiers pas avec Maven

- Étudiez la structure du projet ainsi que le fichier pom.xml.
- Construisez le projet et lancez les tests avec Maven.
- Lancez les tests avec IntelliJ.
- Construisez le site maven du projet et parcourez le contenu du site créé.
- Consultez le rapport de couverture du code par les tests.

### 3. Premiers avec Spring-Boot et la notion de "repository"

- Étudiez le code source de l'application.
- Appuyez vous sur la doucmentation de [Spring Data JPA](http://docs.spring.io/spring-data/jpa/docs/1.11.0.M1/reference/html/) pour comprendre le code de l'application.
- Complétez l'application de telle sorte que le service *CompetenceService* permette la sauvegarde d'un objet de type Categorie (ajout de la méthode *saveCategory(Category cat)*) puis d'un objet de type Comptence (ajout de la méthode *saveCompetence(Competence comp)*).
- À l'issue de votre travail la couvertude du code par les tests doit être supérieure à 90% ; les tests doivent tester les cas de succès, les cas d'erreur, etc.

