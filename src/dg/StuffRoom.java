package dg;

public class StuffRoom extends Room{
	private Stuff stuff;
	
	public StuffRoom() {
		super("Vous tombez sur du stuff");
	}
	
	public Stuff getStuff() {
		return stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	@Override
	public String toString() {
		return  stuff + "" ;
	}

	
}
