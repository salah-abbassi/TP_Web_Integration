# 🌐 TP Programmation Réseau : Sockets TCP & UDP en Java

Ce dépôt contient les travaux pratiques (TP) réalisés dans le cadre du module de programmation réseau (TCP/IP et Java orienté objet). Il illustre la mise en place de communications réseau en utilisant les protocoles TCP et UDP à travers plusieurs exercices pratiques.

---

## 🚀 Instructions de Compilation et d'Exécution

Pour tester les différents exercices de ce TP sur les Sockets, veuillez suivre ces étapes depuis votre terminal :

### 1. Navigation
Placez-vous à la racine du dossier source (`src`) de votre projet :
```bash
cd chemin/vers/votre/projet/src
2. Compilation
Compilez l'ensemble des fichiers Java du package souhaité. Par exemple, pour l'exercice 3 :

Bash
javac Ex3/*.java
Note : Si vous êtes sous Windows, utilisez des antislashs : javac Ex3\*.java ou javac UDP\Ex1\*.java

3. Exécution
Lancez le programme en spécifiant le classpath courant (-cp .) suivi du nom complet de la classe (Package + NomDeLaClasse) et de ses arguments éventuels :

Bash
java -cp . Package.NomDeLaClasse [arguments]
💡 Exemples d'utilisation
Lancer le Serveur de Chat (TCP) :

Bash
java -cp . Ex3.ChatServer
Lancer le Client de Chat Graphique (TCP) :

Bash
java -cp . Ex3.ClientChatGUI
Démarrer un Récepteur de proverbes (UDP) :

Bash
java -cp . UDP.Ex1.Receiver
Envoyer un proverbe sur un port spécifique (UDP) :

Bash
java -cp . UDP.Ex1.SenderProvebe  ```
👨‍💻 Auteur
Salah Eddine Abbassi Élève Ingénieur - 2ème année Business Intelligence & Analytics ENSIAS
