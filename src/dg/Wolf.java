package dg;

public class Wolf extends Enemy{
	
	public Wolf(String name, int randomLife, int randomDamage) {
		super(name, randomLife, randomDamage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Vous tombez sur un " + name + "\nPoint de vie: " + life + "\nPoint d'attaque: " + damage ;
	}
}
