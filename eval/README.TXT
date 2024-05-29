Pour lancer ce projet :

Prérequis :
- Avoir Docker.
- Avoir ddev.


Il suffit d'exécuter la commande 'ddev start' pour démarrer l'environement, puis lancer GameApplication.


/game/question : GET qui retourne le nom du pays pour lequel il faut trouver la capitale.
/game/response : POST avec les paramètres suivants : nomJoueur, idPays, reponse -> indique si c'est correct ou non et gère les points.
/game/score : GET avec le paramètre : nomJoueur -> retourne le score.


Bonus réalisés :

- système de points en bdd en fonction du nom du joueur
- gestion de la casse lors de la réponse