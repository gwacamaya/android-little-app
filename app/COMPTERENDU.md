LOAIZA ARBELAEZ Jhon Anderson
---

Mon application se compose de trois activités:

1. MainActivity.java
2. FaireCourses.java
3. AcheterProduit

### MainActivity.java
Dans l'activité principal, l'utilisateur pourra 
donner un Login dont il souhaite récuperer la liste 
des courses, sais un serveur d'où enqueter les données,
afficher l'heure saisi pour faire les courses avec le bouton
"Heure courses", passer à l'activité 2 avec le bouton 
"Faire les courses", et finalement quitter l'application avec
le bouton "quitter".  

Pour le serveur, il faut que vous le donnez l'adresse complet
avec le fichier à récuperer. Le corps de la réponse doit être
un json (pas json array), come ci-après:  
```json
{
  "jhon" : ["chichen", "rise", "avocato"],
  "neo" : ["fries", "coke", "cigars"],
  "esther" : ["apple", "pie", "juice"],
  "joelle" : ["potato","beans","brocoli","rabbit"]
}
```
Conservez ce format pour ne pas avoir des erreurs. Vous pouvez 
rajouter un key ```"nom"``` avec un value ```["string","array"]```
 ou rajouter des strings aux arrays strings. 
 
 Si vous saisez un URL trompé ou qui n'est pas trouvable par
 l'application, un json static défini par défaut sera chargé en
 mémoire comme example:
 ```json
{
  "jhon":["papas","lechuga","zanahoria"],
  "neo":["pommes","cafe"]
}
                                                            "\"neo\":[\"pommes\",\"cafe\"]}"
```
Le bouton "faire les courses" crée un nouveau intent et donne la
main à l'activité 2, en le passant le string login et l'array
string de la liste d'items.
La classe utilisé pour faires les requêtes Http est Volley

###FaireCourses.java
Vous verrez La liste des courses disponbiles à acheter
avec une petitte salutation au login saisi précédemment.
Veuillez toucher l'item que vous voulez pour passer à l'activité
suivante puis l'acheter.

###AcheterProduit
L'item saisi avant serait affiché et vous aurez deux boutons
qui vous permettront "d'acheter" le produit. Tout simplement,
un Toast sera affiché si vous l'achetez ou pas, indiquand l'action
faite. Après, vous serez rédigé vers l'activité 2.   
Si vous souhaitez essayer avec un autre login, revenez à l'activité
principal avec le bouton "Backwards" du smartphone

## Le modèle
Dans le package model se trouve la clase ```ShoppingAdapter.java``` qui est
le ```ArrayAdapter``` que j'ai créé pour remplir l'écran
de l'activité 2 avec la liste des produits du login. Chaque item,
du type ```TextView``` contient un écouter des événements ```click```.
Lors d'un click, un nouveau intent est créé et donne la main
à l'activité 3 en le passant le string de l'item choisi.

##Les actions
J'ai appelé le package "actions" juste pour y mettre des classes
utiles au développement. Là il comporte justement une classe
```ToastMsg``` qui permet de génerer des Toasts très facile et rapidement.
   


 
