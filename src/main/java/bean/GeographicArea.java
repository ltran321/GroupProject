package bean;

public class GeographicArea {

	private int areaID;
    private String name;

    public GeographicArea(int areaID, String name) {
        this.areaID = areaID;
        this.name = name;
    }

    public int getAreaID() {
        return areaID;
    }

    public String getName() {
        return name;
    }
}
