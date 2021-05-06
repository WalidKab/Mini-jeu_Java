package dg;

public abstract class Characters {

	private String name;
	private int life ;
	private int attackLevel;
	
	
	
	public Characters(String name, int life, int attackLevel) {
		super();
		this.name = name;
		this.life = life;
		this.attackLevel = attackLevel;
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
	public int getAttackLevel() {
		return attackLevel;
	}
	public void setAttackLevel(int attackLevel) {
		this.attackLevel = attackLevel;
	}
	@Override
	public String toString() {
		return "Characters [name=" + name + ", life=" + life + ", attackLevel=" + attackLevel + "]";
	}
	
	
}
