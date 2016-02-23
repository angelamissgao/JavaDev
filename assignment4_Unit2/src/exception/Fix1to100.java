package exception;

import java.io.FileReader;
import java.util.Scanner;

public class Fix1to100 {
	//Fix exception class
	public String fix1() { // input file name wrong
		Scanner s = new Scanner(System.in);
		String line;
		System.out.println("Please type in file name again!");
		while (true) {
			line = s.nextLine();
			if (line == null || line.isEmpty()) {
				System.out.println(
						"Invalid input value, please type in file name again");
			} else {
				try {
					FileReader file = new FileReader(line);
					file.close();
					System.out.println("Typing correctly!");
					break;
				} catch (Exception e) {
					System.out.println(
							"Invalid input value, please type in file name again");
				}
			}
		}
		s.close();
		return line;
	}
}
