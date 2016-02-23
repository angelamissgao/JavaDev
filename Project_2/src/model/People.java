package model;

public abstract class People {
	// People abstract class
	protected int individualId;

	public People(int id) {
		this.individualId = id;
	}

	public abstract void printInfo();
}
