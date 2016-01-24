package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import exception.invalidinputException;
import model.Student;

public class Util {
	public static Student[] readfile(String filename, Student stu[]) throws Exception {
		try{
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			int studentnum = 0;
			
			while (!eof) {
				String line = buff.readLine();
				if(line == null) 
					eof = true;
				
				if(line.startsWith("S")) 
					continue;
					
				if(studentnum > 40) throw new invalidinputException("overloaded student numbers.");
				else {
					String[] str = line.split(" ");
					Integer SID = Integer.parseInt(str[0]);
				    
					int[] scores = new int[5];
					stu[studentnum] = new Student(SID, scores);
					if(str.length > 6) throw new invalidinputException(SID + "Student has more than 4 scores.");
					if(str.length < 6) throw new invalidinputException(SID + "Student has less than 4 scores.");
					for(int i = 1; i < 6; i++){
						if(Integer.parseInt(str[i])>100) throw new invalidinputException(SID + "Student score data is wrong.");
						scores[i-1] = Integer.parseInt(str[i]);
					}
					stu[studentnum].setScores(scores);
					System.out.println(stu[studentnum].getScores()[0]);
					studentnum++;
				}
			}
			buff.close();
		} catch (Exception e) {
			System.out.println("Error ­­ " + e.toString());
			
		}
		  finally{
			//loading process completed
				System.out.println("Loading completed.");
			}
		return stu;
	}
}
