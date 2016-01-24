package model;

public class Student extends People implements Scores{
	private int SID;
	private int scores[] = new int[5];
	
	
	public Student(int id, int[] s){
		super(id);
		this.SID = id;
		setScores(s);
	}
	
	public int getSID() {
		return SID;
	}
	
	@Override
	public int[] getScores() {
		return this.scores;
	}
	
	@Override
	public void setScores(int[] scores) {
		for(int i = 0; i< 5; i++){
			this.scores[i] = scores[i];
		}
	}
	
	@Override
	public void printInfo() {
		System.out.println("This Student Id: " + this.SID);
		for(int i = 0; i < 5; i++) {
			System.out.println(scores[i]);
		}
	}
	
}
