package model;

public class Statistics {
	float[] avgscores = new float[5];
	int count = 0;
	int[] highscores = new int[5];
	int[] lowscores = new int[5];

	public void count(Student[] stu) {
		// count the number of students
		int c = 0;
		for (int i = 0; i < stu.length; i++) {
			if (stu[i] == null || stu[i].getSID() == 0)
				break;
			c++;
		}
		count = c;
	}

	public void findavg(Student[] stu) {
		// find average score
		if (count == 0)
			count(stu);
		for (int quiz = 0; quiz < 5; quiz++) {
			float sum = 0;
			for (int i = 0; i < count; i++) {
				sum = sum + stu[i].getScores()[quiz];
			}
			avgscores[quiz] = sum / count;
		}
	}

	public void findhigh(Student[] stu) {
		// find the highest score
		if (count == 0)
			count(stu);
		for (int quiz = 0; quiz < 5; quiz++) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < count; i++) {
				max = Math.max(max, stu[i].getScores()[quiz]);
			}
			highscores[quiz] = max;
		}
	}

	public void findlow(Student[] stu) {
		// find the lowest score
		if (count == 0)
			count(stu);
		for (int quiz = 0; quiz < 5; quiz++) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < count; i++) {
				min = Math.min(min, stu[i].getScores()[quiz]);
			}
			lowscores[quiz] = min;
		}
	}

	public void showalldata(Student[] stu) {
		System.out.println("All student scores");
		System.out.println("SID\tQ1\tQ2\tQ3\tQ4\tQ5");
		count(stu);
		for (int i = 0; i < count; i++) {
			stu[i].printInfo();
		}
	}

	public void showScores() {
		System.out.println("");
		System.out.printf("low");
		for (int i = 0; i < 5; i++) {
			System.out.printf("\t%d", lowscores[i]);
		}
		System.out.println("");
		System.out.printf("high");
		for (int i = 0; i < 5; i++) {
			System.out.printf("\t%d", highscores[i]);
		}
		System.out.println("");
		System.out.printf("avg");
		for (int i = 0; i < 5; i++) {
			System.out.printf("\t%.1f", avgscores[i]);
		}
		System.out.println("");
		System.out.println("**********************");
		System.out.println("");
	}
}
