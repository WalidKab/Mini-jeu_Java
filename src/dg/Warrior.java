package dg;

public class Warrior extends Characters {
	// Création de variable qui génèrent un chiffre aléatoire pour les points d'attaque et de vie du guerrier	
	int randomInt = 5 + (int) (Math.random()*((10-5)+1));
		
		// Création de variable pour les caractéristiques du perso
		private Weapon weapon; // Objet Weapon de la classe Weapon
		String shield;
		
		// Création d'un constructeur pour la création du guerrier 
		public Warrior(String name, int life, int attackLevel, Weapon weapon, String shield) {
			super(name, life, attackLevel);
			this.weapon = weapon;
			this.shield = shield;
		}
		
		//Création d'un nouveau constreur avec 2 paramètres
		public Warrior(String name, int randomInt, Weapon weapon) {
			this(name, randomInt, randomInt, weapon, "Bouclier nordique");
		}
		
		//Création de la fonction toString qui va return les infos du perso
		public String toString() {
			String newLine=System.getProperty("line.separator"); //Création des retours à la ligne
			return getName() + newLine + getLife() + " PDV" + newLine + "Points d'attaque: " + getAttackLevel() + newLine +
					"Dispose d'une arme: " + weapon + newLine + "A un bouclier: " + shield;
		}
		
		//Création des Getter/Setter qui servent à lire ou à éditer les caractéristiques du perso
		public int getRandomInt() {
			return randomInt;
		}
		public void setRandomInt(int randomInt) {
			this.randomInt = randomInt;
		}
		
		public String getShield() {
			return shield;
		}
		public void setShield(String shield) {
			this.shield = shield;
		}	
		
}
