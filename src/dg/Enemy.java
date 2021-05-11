package dg;

public abstract class Enemy {

	String name;
	int life;
	int damage;
	
	public Enemy(String name, int life, int damage) {
		super();
		this.name = name;
		this.life = life;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return   name + ", life=" + life + ", damage=" + damage ;
	}
	
}
