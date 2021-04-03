## Introduction

Un exemple de gestion des utilisateurs qui utilise
 [Spring Security](https://spring.io/projects/spring-security)
pour protéger certaines parties de votre application.

L'application est [déployée sur heroku](https://gestionutilisateurs.herokuapp.com/).

## Structure

Les utilisateurs de l'application sont représentés par l'entité `Utilisateur`. 
(note : le mot `User` est réservé par Postgresql et ne peut pas être utilisé comme nom de table).

Les utilisateurs peuvent avoir un ou plusieurs rôles (entité `Role`). Deux rôles sont prédéfinis, 
`ROLE_USER` et `ROLE_ADMIN`. Ces deux rôles, ainsi qu'un utilisateur avec le rôle `ROLE_ADMIN`, sont créés automatiquement au démarrage de l'application. 
Les login/password de cet administrateur sont définis dans le fichier `application.properties`

Le template `welcome.html` (page d'accueil de l'application) montre
comment des parties d'une page peuvent être réservées aux utilisateurs connectés,
ou aux utilisateurs qui possèdent un rôle spécifique.

Les contrôleurs `AdminController.java` et `UserController.java` montrent comment
l'accès à un contrôleur particulier peut être réservé aux utilisateurs possédant un rôle spécifique.

## Crédits
Cette application est inspirée de [HelloKoding](https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/),
simplifiée, et ré-écrite pour utiliser H2 et thymeleaf plutôt que MySQL et JSP.
