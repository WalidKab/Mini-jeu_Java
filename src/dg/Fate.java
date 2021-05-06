package dg;

public class Fate extends Attack {
	
		// Création d'un constructeur pour créer un sort
		public Fate(String name, int damage) {
			super(name,damage);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Sort:"+super.toString();
		}
		
		

}
