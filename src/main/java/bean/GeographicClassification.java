package bean;

public class GeographicClassification {

	private String name;
	private int level;
	
	public GeographicClassification(int geoLevel, String geoName) {
		this.level = geoLevel;
		this.name = geoName;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
}
