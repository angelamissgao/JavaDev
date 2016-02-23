package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import exception.InvalidInputException;
import model.Student;

public class Util {
	// Util class to read input file, file IO API applied
	public static Student[] readfile(String filename, Student stu[])
			throws Exception {
		FileReader file = new FileReader(filename);
		BufferedReader buff = new BufferedReader(file);
		boolean eof = false;
		int studentnum = 0;
		try {
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
					break;
				}

				if (line.startsWith("S"))
					continue;

				if (studentnum >= 40)
					// throw an exception when edge case happens
					throw new InvalidInputException(
							"overloaded student numbers.");
				else {
					StringTokenizer str = new StringTokenizer(line);
					Integer SID = Integer.parseInt(str.nextToken());
					int[] scores = new int[5];
					stu[studentnum] = new Student(SID, scores);
					int i = 0;

					if (str.countTokens() > 5)
						throw new InvalidInputException(
								SID + " Student has more than 5 scores.");

					if (str.countTokens() < 5)
						throw new InvalidInputException(
								SID + " Student has less than 5 scores.");

					while (str.hasMoreTokens()) {
						//parse data to student[];
						String cur = str.nextToken();
						if (Integer.parseInt(cur) > 100
								|| Integer.parseInt(cur) < 0)
							throw new InvalidInputException(
									SID + " Student score data is wrong.");
						scores[i++] = Integer.parseInt(cur);
					}
					stu[studentnum].setScores(scores);
					studentnum++;
				}
			}
		} catch (Exception e) {
			System.out.println("Error ­­ " + e.toString());
			// e.printStackTrace();

		} finally {
			buff.close();
			// loading process completed
			System.out.println("Loading completed.");
		}
		return stu;
	}
}
