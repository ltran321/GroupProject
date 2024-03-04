package bean;

public class GeographicAreaDetails {

	private String name;
	private int code;
	private int level;
	private int population;
	
	public GeographicAreaDetails(String name, int code, int level, int population) {
		this.name = name;
		this.code = code;
		this.level = level;
		this.population = population;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
}
