package dg;

public class StuffSpell extends Stuff{
	

	public StuffSpell(String name, int randomImprovement) {
		super(name, randomImprovement);	
	}

	@Override
	public String toString() {
		return "Vous tomber sur un " + name + "\nPoint de dégats ajoutés: +" + improvement ;
	}
	
}
