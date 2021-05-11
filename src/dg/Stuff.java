package dg;

public abstract class Stuff {

	String name;
	int improvement;
	
	public Stuff(String name, int improvement) {
		super();
		this.name = name;
		this.improvement = improvement;
	}
	
	@Override
	public String toString() {
		return "Vous tomber sur un " + name + "\nPoint de dégats: " + improvement;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImprovement() {
		return improvement;
	}
	public void setImprovement(int improvement) {
		this.improvement = improvement;
	}
	
	
}
