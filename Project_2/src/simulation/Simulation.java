package simulation;

// Assignment2-yongchag
import model.Student;
import util.Util;
import model.Statistics;

public class Simulation {
	private static void checkScores(String test) throws Exception {
		Student students[] = new Student[40];

		students = Util.readfile(test, students);

		Statistics statstu = new Statistics();
		statstu.findlow(students);
		statstu.findhigh(students);
		statstu.findavg(students);
		statstu.showalldata(students);
		statstu.showScores();

	}

	public static void main(String[] args) throws Exception {
		// Normal Case;
		String test1 = "src/testcase1.txt";
		System.out.println("testcase1");
		checkScores(test1);

		// Score has more than 40 students;
		String test2 = "src/testcase2.txt";
		System.out.println("testcase2");
		checkScores(test2);

		// Student has more than 5 quiz scores;
		String test3 = "src/testcase3.txt";
		System.out.println("testcase3");
		checkScores(test3);

		// Student has less than 5 quiz scores;
		String test4 = "src/testcase4.txt";
		System.out.println("testcase4");
		checkScores(test4);

		// Student score is wrong;
		String test5 = "src/testcase5.txt";
		System.out.println("testcase5");
		checkScores(test5);
	}
}
