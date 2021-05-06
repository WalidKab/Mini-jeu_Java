package dg;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	Scanner scan; //Initialisation d'un objet scan de la classe Scanner
	
	static boolean requestExit = false; //Création d'un booléen pour la requête servant à quitter le jeu
	
	//Création d'ArrayList pour stocker les gerriers et sorciers créés
	List<Warrior> playerWarrior = new ArrayList<>();
	List<Wizard> playerWizard = new ArrayList<>();
	
	//Création d'une fonction servant à quitter le jeu
	public void exit() {
		requestExit=true; // Le booléen requestExit devient true
	}
	
	// Création d'un menu et d'un nouveau Scanner
	Menu(){
		this.scan= new Scanner(System.in);
	}

	//Création d'une fonction display 
	private void display() {
		// TODO Auto-generated method stub
		System.out.println(playerWarrior); //Affiche le ArrayList de playerWarrior
		System.out.println(playerWizard); //Affiche le ArrayList de playerWizard
		
		System.out.println("Bienvenu dans D&D");
		System.out.println("Pour un guerrier tapez 1, pour un sorcier tapez 2 ou tapez 3 pour quitter");
		int playerChoice = 1;
		try {
			playerChoice = scan.nextInt(); // Variable qui définit le type de perso choisi en fonction de l'entrée clavier
		} catch(Exception e){
		    System.out.println("Petit malin, tu as tapé une lettre, tu auras donc un guerrier de merde");
		}
	
		// Création de variable qui génèrent un chiffre aléatoire pour les points d'attaque et de vie du guerrier	
		int randomInt = 5 + (int) (Math.random()*((10-5)+1)); 

		// Création de variable qui génèrent un chiffre aléatoire pour les points d'attaque et de vie du sorcier	
		int randomLife = 3 + (int) (Math.random()*((6-3)+1));
		int randomAttack = 8 + (int) (Math.random()*((15-8)+1));
		
		//Création d'une condition : si le joueur choisi un guerrier
		if(playerChoice == 1) {
			System.out.println("Vous avez choisi un guerrier");
			scan.nextLine();
			System.out.print("Saisir votre nom : ");
	        String name = scan.nextLine(); //Création du variable qui changera le nom du perso selon les entrées clavier

			System.out.println("Confirmez-vous votre nom? 1 pour oui, 2 pour non");
			int confirm=scan.nextInt(); // Création d'une variable pour confirmer le choix de l'utilisateur concernant le changement de nom
			Weapon a=new Weapon("épée", 12); //Création d'une nouvelle arme avec 2 paramètres
			Warrior g= new Warrior(name, randomInt, randomInt, a,"bouclier"); //Création d'un nouveau warrior

			// Création d'une condition: Si l'utilisateur veut changer de nom
			if(confirm==2) {
				scan.nextLine();
				System.out.print("Saisir votre nom : ");
		        String nameChange = scan.nextLine();
		        g.setName(nameChange); //Appel de la fonction setName pour pouvoir modifier le nom du perso
				System.out.println(g);
			}
			// Condition si l'utilisateur confirme son nom
			else if(confirm == 1) {
				System.out.println(g);
			}
			
			System.out.println("Voulez vous modifier les statistiques de votre personnage? Tapez 1 pour oui, 2 pour non");
			int editCharacter = scan.nextInt(); //Création d'une variable qui va scanner la prochaine entrée clavier (int)
			
				// Création d'une condition: si l'utilisateur veut modifier son guerrier
				if(editCharacter == 1) {
					System.out.println("Vos points d'attaque: ");
					g.setAttackLevel(scan.nextInt()); //Modifie les points d'attaque
					scan.hasNextLine();
					System.out.println("Vos points de vie: ");
					g.setLife(scan.nextInt()); // Modifie les points de vie
					scan.nextLine();
					System.out.println("Votre bouclier: ");
					g.setShield(scan.nextLine()); // Modifie le nom du bouclier
					System.out.println("Les dégats de votre arme: ");
					a.setDamage(scan.nextInt()); // Modifie les points de dommage de l'arme (weapon)
					scan.nextLine();
					System.out.println("Le nom de votre arme:");
					a.setName(scan.nextLine()); // Modifie le nom de l'arme (weapon)
					System.out.println(g);
					playerWarrior.add(g); // Ajoute le nouveau guerrier à l'ArrayList playerWarrior
				}
				// Si le joueur ne veut pas modifier son perso
				else if (editCharacter == 2) {
					System.out.println(g);
					playerWarrior.add(g);
				}
		}
			
			// Si le joueur choisi un sorcier
			if(playerChoice == 2) {
				System.out.println("Vous avez choisi un sorcier");
				scan.nextLine();
				System.out.print("Saisir votre nom : ");
		        String name = scan.nextLine(); // Créer le nom du sorcier

				System.out.println("Confirmez-vous votre nom? 1 pour oui, 2 pour non");
				int confirm=scan.nextInt();
				Fate f=new Fate("Boule de feu", 12); //Création d'un nouveau sort avec 2 paramètres
				Wizard w= new Wizard(name, randomLife, randomAttack, f, "Philtre de sang"); //Création d'un nouveau sorcier			
				
				//Si l'utilisateur veut modifier le nom du perso
				if(confirm==2) {
					scan.nextLine();
					System.out.print("Saisir votre nom : ");
			        String nameChange = scan.nextLine();
			        w.setName(nameChange);
					System.out.println(w);
					
				}
				//Si le joueur ne veut pas modifier son nom
				else if(confirm == 1) {
					System.out.println(w);
				}
				
				System.out.println("Voulez vous modifier les statistiques de votre personnage? Tapez 1 pour oui, 2 pour non");
				int editCharacterWizard = scan.nextInt(); //Création d'une variable qui va scanner la prochaine entrée clavier (int) pour savoir si le joueur veut modifier son perso
			
				// Création d'une condition: si l'utilisateur veut modifier son sorcier
					if(editCharacterWizard == 1) {
						System.out.println("Vos points d'attaque: ");
						w.setAttackLevel(scan.nextInt()); // Modifie les points d'attaque
						scan.hasNextLine();
						System.out.println("Vos points de vie: ");
						w.setLife(scan.nextInt()); // Modifie les point de vie
						scan.nextLine();
						System.out.println("Votre philtre: ");
						w.setPhiltre(scan.nextLine()); // Modifie les philtres
						System.out.println("Nom de votre sort: ");
						f.setName(scan.nextLine()); //Modifie le nom des sorts
						System.out.println("Dégats de votre sort: ");
						f.setDamage(scan.nextInt()); // Modifie les points de dommage
						System.out.println(w);
						playerWizard.add(w);
					}
					//Si l'utilistaeur ne veut pas modifier son perso
					else if (editCharacterWizard == 2) {
						System.out.println(w);
						playerWizard.add(w); // Ajoute à l'ArrayList playerWizard
					}
			}
		
			//Si l'utilisateur tape 3 pour quitter le jeu
		else if(playerChoice == 3) {
			System.out.println("Vous avez quitté le jeu");
			exit(); // Appel de la fonction exit 
		}
		
	}

	// Création d'une fonction main qui démarre le jeu
	public static void main(String args[]) {
		Menu m = new Menu(); // Création d'un nouveau menu
		do {
		m.display(); // Affiche le menu + la fonction display
		}
		while(!requestExit); // Affiche le menu tant que l'utilisateur n'a pas demandé de quitter

		
	}

}
