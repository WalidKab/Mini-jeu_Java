package dg;

public class StuffWeapon extends Stuff{
		
	public StuffWeapon(String name, int randomImprovement) {
		super(name, randomImprovement);
		
	}

	@Override
	public String toString() {
		return "Vous tomber sur un " + name + "\nPoint de dégats ajoutés: +" + improvement ;
	}
	

}
