package dg;

public class Zombie extends Enemy{

	public Zombie(String name, int randomLife, int randomDamage) {
		super(name, randomLife, randomDamage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Vous tombez sur un " + name + "\nPoint de vie: " + life + "\nPoint d'attaque: " + damage ;
	}

}
