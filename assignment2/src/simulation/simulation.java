package simulation;

import model.Student;
import Util.Util;
import model.Statistics;

public class simulation {
	public static void main(String[] args) throws Exception {
		String test1 = "src/testcase1.txt";
		checkScores(test1);
	}
	
	private static void checkScores (String test) throws Exception {
		Student students [] = new Student[40];
		
		students = Util.readfile(test,students);
		Statistics statstu = new Statistics();
		statstu.findlow(students);
		statstu.findhigh(students);
		statstu.findavg(students);
		statstu.showScores();
	
		
		
	}
}
