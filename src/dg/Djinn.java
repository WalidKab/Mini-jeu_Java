package dg;

public class Djinn extends Enemy{
	
	public Djinn(String name, int randomLife, int randomDamage) {
		super(name, randomLife, randomDamage);
	}

	@Override
	public String toString() {
		return "Vous tombez sur un " + name + "\nPoint de vie: " + life + "\nPoint d'attaque: " + damage ;
	}	
}