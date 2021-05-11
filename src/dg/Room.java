package dg;

public abstract class Room {
	
	private String welcome;
	
	public Room(String welcome) {
		this.welcome = welcome;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	@Override
	public String toString() {
		return welcome;
	}
	
}
