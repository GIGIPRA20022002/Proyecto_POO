============================================
       DUNGEON ADVENTURE - L3 Informatique
============================================

 UN JEU D'AVENTURE EN MODE TEXTE
Projet POO & IHM - Université de Poitiers

============================================
 DÉMARRAGE ULTRA-RAPIDE
============================================

1. Extraire l'archive ZIP
2. Ouvrir un terminal dans le dossier
3. Taper: java -cp bin adventure.Main
4. Taper "help" pour commencer

 C'est tout! Les fichiers sont déjà compilés.

============================================
 PRÉREQUIS
============================================

• Java JDK 21 ou +
• Terminal/CMD/PowerShell

Vérifier: java -version

============================================
 COMMENT JOUER
============================================

OBJECTIF:
Atteindre la Salle 4 et sortir par l'est.

COMMANDES ESSENTIELLES:
• go nord/sud/est/ouest  : Se déplacer
• look                   : Examiner
• take <objet>           : Prendre (1 seul!)
• drop                   : Déposer
• use <objet>            : Utiliser
• attack monster/fireball: Attaquer
• open <direction>       : Ouvrir porte
• help                   : Aide complète
• restart                : Recommencer
• quit                   : Quitter

============================================
 POUR LES PRESSÉS
============================================

WINDOWS:
1. Double-cliquer sur "start-game.bat"
2. ou: java -cp bin adventure.Main

LINUX/MAC:
1. Terminal → java -cp bin adventure.Main

VS CODE:
1. Ouvrir Main.java
2. Cliquer sur "Run" 

============================================
CONSEILS
============================================

• Inventaire limité à 1 objet
• Chaque 3 actions = -1 HP
• Fire Demon → Seulement Fireball
• Taper "help" pour liste complète

============================================
PROBLÈMES COURANTS
============================================

"java: command not found"
→ Installer Java 21: https://jdk.java.net/21/

"Could not find or load main class"
→ Vérifier: java -cp bin adventure.Main

============================================
 CONTENU DE L'ARCHIVE
============================================

bin/      → Fichiers compilés (prêts)
src/      → Code source
README.txt → Ces instructions
start-game.bat → Lanceur Windows
rapport.pdf → Documentation complète

============================================
 CRÉDITS
============================================

Juan Jose Giraldo & Sebastian Costain 
L3 Informatique - Université de Poitiers
POO & IHM 1 - 2025/2026

============================================
RÉSUMÉ ÉVALUATION
============================================

Test rapide:
1. java -cp bin adventure.Main
2. help → look → take Key1 → open north
3. go north → drop → take Key2 → etc.

Temps: 10-15 min pour une partie complète.

============================================
 BON JEU!
============================================