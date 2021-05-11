package dg;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {

	Scanner scan; //Initialisation d'un objet scan de la classe Scanner
	
	static boolean requestExit = false; //Création d'un booléen pour la requête servant à quitter le jeu
	
	//Création d'ArrayList pour stocker les gerriers et sorciers créés
	List<Characters> players = new ArrayList<>();
	
    String name; //Création du variable qui changera le nom du perso selon les entrées clavier
	// Création de variable qui génèrent un chiffre aléatoire pour les points d'attaque et de vie du guerrier	
	int randomInt = 5 + (int) (Math.random()*((10-5)+1)); 

	// Création de variable qui génèrent un chiffre aléatoire pour les points d'attaque et de vie du sorcier	
	int randomLife = 3 + (int) (Math.random()*((6-3)+1));
	int randomAttack = 8 + (int) (Math.random()*((15-8)+1));
	
	//Weapon a=new Weapon("épée", 12); //Création d'une nouvelle arme avec 2 paramètres
	//Warrior g= new Warrior(name, randomInt, randomInt, a,"bouclier"); //Création d'un nouveau warrior
	
	Fate f=new Fate("Boule de feu", 12); //Création d'un nouveau sort avec 2 paramètres
	Wizard w= new Wizard(name, randomLife, randomAttack, f, "Philtre de sang"); //Création d'un nouveau sorcier
	
	int playerChoice ;
	int confirm;
	
	Room [] cases= new Room [10];
	
	//Création d'une fonction servant à quitter le jeu
	public void exit() {
		System.out.println("Vous avez quitté le jeu");
		requestExit=true; // Le booléen requestExit devient true
	}
	
	// Création d'un menu et d'un nouveau Scanner
	Menu(){
		this.scan= new Scanner(System.in);
	}

	//Création d'une fonction display 
	private void display() {
		// TODO Auto-generated method stub

		System.out.println("0 pour lancer la partie \n1 pour créer un nouveau personnage \n2 pour afficher la liste des personnages \n3 pour éditer un personnage \n4 pour supprimer un personnage \n5 pour quitter");
		int crudCharacter = scan.nextInt();
		
		if(crudCharacter == 1) {
			System.out.println("Pour un guerrier tapez 1, pour un sorcier tapez 2 ou tapez 3 pour revenir au menu principal");
			try {
				playerChoice = scan.nextInt(); // Variable qui définit le type de perso choisi en fonction de l'entrée clavier
			} catch(Exception e){
				playerChoice = 1;
			    System.err.println("Petit malin, tu as tapé une lettre, tu auras donc un guerrier de merde");
			}
			
			//Création d'une condition : si le joueur choisi un guerrier
			if(playerChoice == 1) {
				createWarrior();
			}
				
				// Si le joueur choisi un sorcier
				if(playerChoice == 2) {
					createWizard();
				}
		}
		
		else if(crudCharacter == 0) {
			play();
			move();
		}
		
		else if(crudCharacter==2) {
			System.out.println("_______________________\nTous les personnages" + players);
		}
		
		else if(crudCharacter==3) {
			if (players.size() !=0) {
				System.out.println("_______________________\nTous les guerriers" + players);
				System.out.println("Quel personnage voulez-vous modifier?");
				scan.nextLine();
		        String whichCharacterEdit = scan.nextLine();
		        for(Characters player : players) {
		        	if (whichCharacterEdit.equals(player.getName())) {
		        		if(player instanceof Warrior) {
		        			editWarrior((Warrior) player);
		        		}
		        		if(player instanceof Wizard) {
		        			editWizard((Wizard) player);
		        		}
		        	}
		        }

			}
		}
		
		else if(crudCharacter==4) {
			deleteCharacter();
		}
		
		else if(crudCharacter==5) {
			exit(); // Appel de la fonction exit 
		}
		
		//Si l'utilisateur tape 3 pour quitter le jeu
		else if(playerChoice == 3) {
			System.out.println("Vous avez quitté le jeu");
			exit(); // Appel de la fonction exit 
		}
	
	}

	private void deleteCharacter() {
		if (players.size() !=0) {
		System.out.println("Taper l'id du personnage pour le supprimer");
		for(int i=0; i<players.size(); i++) {
			System.out.println("Id: "+ i +" nom du personnage: "+ players.get(i).getName() );
		}
		int deleteCharacter = scan.nextInt();
		Characters w = this.players.get(deleteCharacter);
		players.remove(deleteCharacter);
		
		System.out.println(w.getName());
		}
		else {
			System.out.println("La liste est vide");
		}
	}

	private void createWizard() {
		System.out.println("Vous avez choisi un sorcier");
		scan.nextLine();
		System.out.print("Saisir votre nom : ");
		w.setName(scan.nextLine()); // Créer le nom du sorcier

		System.out.println("Confirmez-vous votre nom? 1 pour oui, 2 pour non");
		int confirm=scan.nextInt();

		//Si l'utilisateur veut modifier le nom du perso
		if(confirm==2) {
			scan.nextLine();
			System.out.print("Saisir votre nom : ");
		    String nameChange = scan.nextLine();
		    w.setName(nameChange);
			System.out.println("_______________________\nVotre personnage a été créé:  " + w +"\n_______________________");
			
		}
		//Si le joueur ne veut pas modifier son nom
		else if(confirm == 1) {
			System.out.println("_______________________\nVotre personnage a été créé:  " + w +"\n_______________________");
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
				System.out.println("_______________________\nVotre personnage a été créé:  " + w +"\n_______________________");
				players.add(w);
			}
			//Si l'utilistaeur ne veut pas modifier son perso
			else if (editCharacterWizard == 2) {
				System.out.println("_______________________\nVotre personnage a été créé:  " + w +"\n_______________________");
				players.add(w); // Ajoute à l'ArrayList playerWizard
			}
	}

	private void createWarrior() {
		System.out.println("Vous avez choisi un guerrier");
		scan.nextLine();
		System.out.print("Saisir votre nom : ");
		String name = scan.nextLine();  //Création du variable qui changera le nom du perso selon les entrées clavier

		System.out.println("Confirmez-vous votre nom? 1 pour oui, 2 pour non");
		confirm=scan.nextInt(); // Création d'une variable pour confirmer le choix de l'utilisateur concernant le changement de nom
		
		// Création d'une condition: Si l'utilisateur veut changer de nom
		if(confirm==2) {
			scan.nextLine();
			System.out.print("Saisir votre nom : ");
			name = scan.nextLine();			
		}
		// Condition si l'utilisateur confirme son nom

		Weapon a = new Weapon("Epée", 5);
		Warrior g= new Warrior(name, randomInt, randomInt, a,"bouclier");
		
		System.out.println("_______________________\nVotre personnage a été créé:  " + g +"\n_______________________");
		
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
				System.out.println("_______________________\nVotre personnage a été créer:  " + g +"\n_______________________");
				players.add(g); // Ajoute le nouveau guerrier à l'ArrayList playerWarrior
			}
			// Si le joueur ne veut pas modifier son perso
			else if (editCharacter == 2) {
				System.out.println("_______________________\nVotre personnage a été créer:  " + g +"\n_______________________");
				players.add(g);
			}
	}

	private void editWarrior(Warrior player) {
		System.out.println("Nom : " + player.getName());
		System.out.println("Que voulez-vous changer ?");
		System.out.println("#1 Le nom de votre personnage");
		System.out.println("#2 L'arme de votre personnage");
		System.out.println("#3 Le nom du bouclier de votre personnage");
		int whichEdit = scan.nextInt();
		scan.nextLine();
		if (whichEdit == 1) {
		    System.out.println("Entrez votre nouveau nom :");
		    player.setName(scan.nextLine());
		}
		else if (whichEdit == 2) {
		    System.out.println("Entrer le nouveau nom de votre arme:");
		    Weapon a= new Weapon(scan.nextLine(), 5);
		    player.setWeapon(a);
		}
		else if (whichEdit == 3) {
			System.out.println("Entrer le nom du bouclier de votre personnage");
			player.setShield(scan.nextLine());
		}
	}
	
	private void editWizard(Wizard player) {
		System.out.println("Nom : " + player.getName());
		System.out.println("Que voulez-vous changer ?");
		System.out.println("#1 Le nom de votre personnage");
		System.out.println("#2 Le nom du sort de votre personnage");
		System.out.println("#3 Le nom du philtre de votre personnage");
		int whichEdit = scan.nextInt();
		scan.nextLine();
		if (whichEdit == 1) {
		    System.out.println("Entrez votre nouveau nom :");
		    player.setName(scan.nextLine());
		}
		else if (whichEdit == 2) {
		    System.out.println("Entrer le nouveau nom de votre sort:");
			Fate f=new Fate(scan.nextLine(), 12); //Création d'un nouveau sort avec 2 paramètres
		    player.setFate(f);
		}
		else if (whichEdit == 3) {
			System.out.println("Entrer le nom du philtre de votre personnage");
			player.setPhiltre(scan.nextLine());
		}
	}
	
	public void startGame() {
		System.out.println("==============================\n      Bienvenu dans D&D\n==============================");
	}
	
	public Room[] play() {		
		//cases[0]=cases[9] = new EmptyRoom();
		for(int i=1; i<cases.length; i++) {
			int roomRandom = 1 + (int) (Math.random()*((3-1)+1));
			Random random=new Random();
			int randomEnemy = (random.nextInt(3))+1;
			Random random1=new Random();
			int randomStuff=(random1.nextInt(4))+1;
			
			if(roomRandom==1) {
				cases[i] = new EmptyRoom();
			}
			else if(roomRandom==2) {
				EnnemyRoom enemyRoom = new EnnemyRoom();
				if(randomEnemy == 1) {
					Random randomZombie=new Random();
					int randomLife = (randomZombie.nextInt(5))+1;
					int randomDamage = (randomZombie.nextInt(10))+1;
					Zombie zombie = new Zombie("Zombie", randomLife, randomDamage);
					enemyRoom.setEnemy(zombie);
				}
				else if(randomEnemy==2) {
					Random randomWolf=new Random();
					int randomLife = (randomWolf.nextInt(5))+1;
					int randomDamage = (randomWolf.nextInt(10))+1;
					Wolf wolf = new Wolf("Loup Géant", randomLife, randomDamage);
					enemyRoom.setEnemy(wolf);
				}
				else if(randomEnemy==3) {
					Random randomDjinn=new Random();
					int randomLife = (randomDjinn.nextInt(5))+1;
					int randomDamage = (randomDjinn.nextInt(10))+1;
					Djinn djinn = new Djinn("Djinn", randomLife, randomDamage);
					enemyRoom.setEnemy(djinn);
				}
				cases[i]= enemyRoom;
			}
			else if(roomRandom==3) {
				StuffRoom stuffRoom = new StuffRoom();
				if(randomStuff==1) {
					Random randomImprovement= new Random();
					int improvement=(randomImprovement.nextInt(24))+1;
					StuffShield stuffShield= new StuffShield("Bouclier",improvement);
					stuffRoom.setStuff(stuffShield);
				}
				else if(randomStuff==2) {
					Random randomImprovement= new Random();
					int improvement=(randomImprovement.nextInt(25))+1;
					StuffWeapon stuffWeapon= new StuffWeapon("Epée",improvement);
					stuffRoom.setStuff(stuffWeapon);
				}
				else if(randomStuff==3) {
					Random randomImprovement= new Random();
					int improvement=(randomImprovement.nextInt(10))+1;
					StuffPhiltre stuffPhiltre= new StuffPhiltre("Philtre de ouf",improvement);
					stuffRoom.setStuff(stuffPhiltre);
				}
				else if(randomStuff==4) {
					Random randomImprovement= new Random();
					int improvement=(randomImprovement.nextInt(15))+1;
					StuffSpell stuffSpell= new StuffSpell("Sort de givre",improvement);
					stuffRoom.setStuff(stuffSpell);
				}
				cases[i]= stuffRoom;
			}
		}
		return cases;
	}
	
	public void move() {
		int position = 0;
		while(position<=8) {
			System.out.println("Tapez 1 pour avancer, 0 Pour quitter le jeu");
			if(scan.nextInt()==1) {
				position += 1;
				System.out.println(this.cases[position]);
			}
			else if (scan.nextInt()==0) {
				exit();
			}
		}
	}
	
	// Création d'une fonction main qui démarre le jeu
	public static void main(String args[]) {
		Menu m = new Menu(); // Création d'un nouveau menu
		m.startGame();
		do {
		m.display(); // Affiche le menu + la fonction display
		}
		while(!requestExit); // Affiche le menu tant que l'utilisateur n'a pas demandé de quitter
	}

}
