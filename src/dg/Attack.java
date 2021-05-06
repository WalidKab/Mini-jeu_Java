package dg;

public abstract class Attack {
	
	private String name; 
	private int damage;
	
	public Attack(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	// Création d'une fonction toString afin d'afficher les caractéristiques du sort
	@Override
	public String toString() {
		return "[name=" + name + ", damage=" + damage + "]";
	}
	
}
