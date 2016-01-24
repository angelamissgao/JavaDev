package model;

public class Statistics {
	int[] lowscores = new int[5];
	int[] highscores = new int[5];
	float[] avgscores = new float[5];
	int count = 0;
	
	public void count(Student[] stu){
		int c = 0;
		for (int i = 0; i < stu.length; i++){
			if(stu[i] == null || stu[i].getSID() == 0)
				break;
			c++;
		}
		count = c;
	}
	
	public void findlow(Student[] a){
		if(count == 0) count(a);
		for(int quiz = 0; quiz < 5; quiz++) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < count; i++){
				min = Math.min(min, a[i].getScores()[quiz]);
			}
			lowscores[quiz] = min;
		}	
	}
	
	public void findhigh(Student[] a){
		if(count == 0) count(a);
		for(int quiz = 0; quiz < 5; quiz++) {
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < count; i++){
				max = Math.max(max, a[i].getScores()[quiz]);
			}
			highscores[quiz] = max;
		}
	}
	
	public void findavg(Student[] a){
		if(count == 0) count(a);
		for(int quiz = 0; quiz < 5; quiz++) {
			float sum = 0;
			for(int i = 0; i < count; i++){
				sum = sum + a[i].getScores()[quiz];
			}
			avgscores[quiz] = sum/count;
		}
	}
	
	public void showScores(){
		for(int i = 0; i< 5; i++){
		 System.out.println("lowest score" + lowscores[i]);
	     System.out.println("highest score"+ highscores[i]);
	     System.out.println("Average score" + avgscores[i]);
		}
	}
}
