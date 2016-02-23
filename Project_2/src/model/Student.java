package model;

public class Student extends People implements Scores {
	// Student extend from people abstract class and implement score interface;
	public int scores[] = new int[5];

	public Student(int id, int[] s) {
	//constructor
		super(id);
		setScores(s);
	}

	@Override
	public int[] getScores() {
		return this.scores;
	}

	public int getSID() {
		return individualId;
	}

	@Override
	public void printInfo() {
		System.out.printf("%d", this.individualId);
		for (int i = 0; i < 5; i++) {
			System.out.printf("\t%d", scores[i]);
		}
		System.out.println("");
	}

	@Override
	public void setScores(int[] scores) {
		for (int i = 0; i < 5; i++) {
			this.scores[i] = scores[i];
		}
	}

}
