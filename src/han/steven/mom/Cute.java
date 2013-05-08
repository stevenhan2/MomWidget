package han.steven.mom;

public class Cute {
	public int image;
	public String name;
	public String saying;
	
	public Cute(int image, String name, String saying){
		this.image = image;
		this.name = name;
		this.saying = saying;
	}
	
	public String toString(){
		return "name" + ":" + saying;
	}
}
