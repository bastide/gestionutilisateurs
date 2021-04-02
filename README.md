## Introduction

Un exemple de gestion des utilisateurs qui utilise
 [Spring Security](https://spring.io/projects/spring-security)
pour protéger certaines parties de votre application.

L'application est [déployée sur heroku](https://gestionutilisateurs.herokuapp.com/).

## Structure

Les utilisateurs de l'application sont représentés par l'entité `User`.
Les utilisateurs peuvent avoir un ou plusieurs rôles (entité `Role`). Deux rôles sont prédéfinis, 
`ROLE_USER` et `ROLE_ADMIN` (voir le fichier `data.sql` qui crée ces rôles dans la base de données).

Un utilisateur avec le rôle `ROLE_ADMIN` est créé automatiquement au démarrage de l'application. 
Ses login/password sont définis dans le fichier `application.properties`

Le template `welcome.html` (page d'accueil de l'application) montre
comment des parties d'une page peuvent être réservées aux utilisateurs connectés,
ou aux utilisateurs qui possèdent un rôle spécifique.

Les contrôleurs `AdminController.java` et `UserController.java` montrent comment
l'accès à un contrôleur particulier peut être réservé aux utilisateurs possédant un rôle spécifique.

## Crédits
Cette application est inspirée de [HelloKoding](https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/),
simplifiée, et ré-écrite pour utiliser H2 et thymeleaf plutôt que MySQL et JSP.
