package dg;

public class Wizard extends Characters{
	// Création de variable qui génèrent un chiffre aléatoire pour les points d'attaque et de vie du sorcier
	int randomLife = 3 + (int) (Math.random()*((6-3)+1));
	int randomAttack = 8 + (int) (Math.random()*((15-8)+1));
	
		// Création de variable pour les caractéristiques du perso
		private Fate fate; //Objet sort de la classe Fate
		String philtre;
		
		// Création d'un constructeur pour la création du sorcier
		public Wizard(String name, int life, int attackLevel, Fate sort, String philtre) {
			super(name, life, attackLevel);
			this.fate = sort;
			this.philtre = philtre;
		}
		
		//Création d'un nouveau constreur avec 3 paramètres
		public Wizard(String name, int randomLife, int randomAttack) {
			this(name, randomLife, randomAttack, new Fate("Boule de feu", 7), "Philtre de sang de bourbe");
		}
		
		//Création de la fonction toString qui va return les infos du perso
		public String toString() {
			String newLine=System.getProperty("line.separator");
			return getName() + newLine + getLife() + " PDV" + newLine + "Points d'attaque: " + getAttackLevel() + newLine + 
					"Dispose d'un sort: " + fate + newLine + "A un philtre: " + philtre;
		}
		
		//Création des Getter/Setter qui servent à lire ou à éditer les caractéristiques du perso
		public int getRandomLife() {
			return randomLife;
		}

		public void setRandomLife(int randomLife) {
			this.randomLife = randomLife;
		}

		public int getRandomAttack() {
			return randomAttack;
		}

		public void setRandomAttack(int randomAttack) {
			this.randomAttack = randomAttack;
		}

		public String getPhiltre() {
			return this.philtre;
		}

		public void setPhiltre(String philtre) {
			this.philtre = philtre;
		}
		
		public void setFate(Fate sort) {
			this.fate = sort;
		}
}
