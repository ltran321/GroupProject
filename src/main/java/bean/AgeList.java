package bean;

public class AgeList {
	private int Year;
	private int MalePopulation;
	private int FemalePopulation;
	
	
	
	public AgeList(int year, int malePopulation, int femalePopulation) {
		super();
		Year = year;
		MalePopulation = malePopulation;
		FemalePopulation = femalePopulation;
	}
	
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getMalePopulation() {
		return MalePopulation;
	}
	public void setMalePopulation(int malePopulation) {
		MalePopulation = malePopulation;
	}
	public int getFemalePopulation() {
		return FemalePopulation;
	}
	public void setFemalePopulation(int femalePopulation) {
		FemalePopulation = femalePopulation;
	}
}
