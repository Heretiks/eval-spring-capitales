Pour lancer ce projet :

Prérequis :
- Avoir Docker.
- Avoir ddev.


Il suffit d'exécuter la commande 'ddev start' pour démarrer l'environement, puis lancer GameApplication.


/game/question : GET qui retourne le nom du pays pour lequel il faut trouver la capitale.
/game/response : POST avec les paramètres suivants : playerName, idPays, answer -> indique si c'est correct ou non et gère les points.
/game/score : POST avec le paramètre : playerName -> retourne le score.


Bonus réalisés :

- système de points en bdd en fonction du nom du joueur (dans le script sql j'ai ajouter la création de la table players et d'un player 'test')
- gestion de la casse lors de la réponse