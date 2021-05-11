package dg;

public class StuffShield extends Stuff{
	

	public StuffShield(String name, int randomImprovement) {
		super(name, randomImprovement);
	}
	
	@Override
	public String toString() {
		return "Vous tomber sur un " + name + "\nPoint de défense ajoutés: +" + improvement ;
	}

	
}
