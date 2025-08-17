# Application Web Service SOAP : Secteurs et Classes

Ce projet est une application multi-module qui implémente un Web Service basé sur le protocole SOAP (Simple Object Access Protocol). L'architecture sépare la logique métier du cœur de l'application de la couche d'exposition du service.

## 🚀 Architecture des modules

Le projet est divisé en deux modules principaux :

* **`metier-module`** : Ce module contient la logique métier de l'application. Il est indépendant et regroupe tous les éléments essentiels tels que les entités, les services et la couche d'accès aux données.
* **`soap-module`** : Ce module expose le Web Service SOAP. Il dépend du `metier-module` pour accéder à la logique de l'application. C'est dans ce module que se trouvent les endpoints et le fichier WSDL.

---

## 🛠️ Technologies et Outils

* **Java 17**
* **Maven** pour la gestion des dépendances et la construction des modules.
* **Serveur Tomcat** pour le déploiement de l'application.
* **MySQL 8** pour la base de données.
* **Web Service SOAP**
* **WSDL** (Web Services Description Language)
* **XML** (Extensible Markup Language)
* **SoapUI** pour les tests.

---

## ⚙️ Prérequis

Pour lancer l'application, assurez-vous d'avoir les éléments suivants installés :

* **JDK 17**
* **Maven 3.x**
* **Tomcat 9 ou supérieur**
* **MySQL 8**

---

## ▶️ Comment lancer l'application

Pour démarrer l'application, vous devez d'abord générer le fichier de déploiement, puis le déployer sur le serveur Tomcat.

1.  **Générer le fichier `.war`**
    * Naviguez dans le dossier racine du projet (`soap-module`).
    * Utilisez la commande Maven pour compiler et packager l'application :

    ```bash
    mvn clean install
    ```
    Cette commande va créer un fichier `.war` (par exemple, `soap-module-1.0-SNAPSHOT.war`) dans le dossier `target` du `soap-module`.

2.  **Déployer sur Tomcat**
    * Copiez le fichier `.war` et collez-le dans le dossier `webapps` de votre installation de Tomcat.
    * Démarrez votre serveur Tomcat. Tomcat va automatiquement déployer l'application et la rendre accessible.

3.  **Vérifier le déploiement**
    * Une fois que Tomcat est démarré, le service sera accessible via l'URL : `http://localhost:8081/soap_war_exploded/SettingsWebService?wsdl`.

---

## 🧪 Comment tester le Web Service

Pour tester l'application, utilisez l'outil **SoapUI** pour envoyer des requêtes SOAP.

1.  **Vérifiez le WSDL** : Accédez à la description de votre service en ouvrant cette URL dans votre navigateur.
    * `http://localhost:8081/soap_war_exploded/SettingsWebService?wsdl`
    ![Capture d'écran du fichier WSDL](https://gitlab.com/-/project/72708354/uploads/ad394c406571195c44fd5f4e75e4800a/wsdl.png)

### 📸 Preuve des tests

Chaque test a été vérifié au niveau de l'outil de test (**SoapUI**), de la console de l'application et de la base de données **MySQL**.

#### Test 1 : Ajouter un Secteur (`addSector`)

* **Requête SOAP** :
    ![Requête pour ajouter un secteur](https://gitlab.com/-/project/72708354/uploads/37adf8978b8163d3cffac4350b74603c/addSectorsoapui.png)
* **Résultat dans la console** :
    ![Logs de l'insertion d'un secteur](https://gitlab.com/-/project/72708354/uploads/4d1b1f8585d9d857ec34d052b5a4eaa6/addSectorConsole.png)
* **Résultat dans la base de données** :
    ![Données de la table Secteurs](https://gitlab.com/-/project/72708354/uploads/b720207df62212cd3b22be2a27db3c2e/addSectorDatabase.png)

#### Test 2 : Ajouter une Classe (`addClasse`)

* **Requête SOAP** :
    ![Requête pour ajouter une classe](https://gitlab.com/-/project/72708354/uploads/6638fe9e1c037a1d0a14b8dcb64b04a6/addClassesoapui.png)
* **Résultat dans la console** :
    ![Logs de l'insertion d'une classe](https://gitlab.com/-/project/72708354/uploads/b723238b783e90c5e40468d98d1d5fd4/addClasseConsole.png)
* **Résultat dans la base de données** :
    ![Données de la table Classes](https://gitlab.com/-/project/72708354/uploads/e57e7c288f82054ce72b659c04e3567d/addClasseDatabase.png)

#### Test 3 : Récupérer tous les secteurs (`getAllSector`) 

* **Requête et réponse SOAP** : 
    ![Requête et réponse XML de tous les secteurs](https://gitlab.com/-/project/72708354/uploads/859a5e019eea5a2b62760e20a5b1fbbb/getAllsector.png)

#### Test 4 : Récupérer une classe par secteur (`getClasseBySector`)

* **Requête et réponse SOAP** : 
    ![Requête et réponse XML d'une classe par secteur](https://gitlab.com/-/project/72708354/uploads/91c2aa909db227aca5a961a91a918af7481/getClassebysector.png)
