package model;

public abstract class People {
	private int individualId;
	
	public People(int id){
		this.individualId = id;
	}
	
	public abstract void printInfo();
}
