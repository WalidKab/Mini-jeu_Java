package dg;

public class EnnemyRoom extends Room{
	private Enemy enemy;
	
	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public EnnemyRoom() {
		super("Vous tombez sur un ennemi");
	}

	@Override
	public String toString() {
		return "Attention!!\n" + enemy ;
	}

}
