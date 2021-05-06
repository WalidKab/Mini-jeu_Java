package dg;

public class Weapon extends Attack {

	// Création d'un constructeur pour créer une arme
	public Weapon(String name, int damage) {
		super(name, damage);
	}

	// Création d'une fonction toString afin d'afficher les caractéristiques de l'arme
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Arme:"+super.toString();
	}
	
}