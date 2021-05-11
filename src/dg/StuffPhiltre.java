package dg;

public class StuffPhiltre extends Stuff{
	
	public StuffPhiltre(String name, int randomImprovement) {
		super(name, randomImprovement);
		
	}

	@Override
	public String toString() {
		return "Vous tomber sur un " + name + "\nPoint de défense ajoutés: +" + improvement ;
	}


}
