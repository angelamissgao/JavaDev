package driver;

import model.Automotive;
import util.FileIO;

public class Driver {
    public static void main(String[] args) {
        try {
            // Test case 1
            // Build Automobile Object from a file.
            FileIO fileio = new FileIO();
            Automotive FordZTW = fileio.buildAutoObject("FordZTW.txt");
            // Print attributes before serialization
            FordZTW.print();

            // Serialize the object
            fileio.serializeAuto(FordZTW, "auto.ser");
            // Deserialize the object and read it into memory.
            Automotive newFordZTW = fileio.deserializeAuto("auto.ser");
            // Print new attributes.
            System.out.println("#################################");
            newFordZTW.print();

            System.out.println("**********************************");

            // Test case 2
            // Build Automobile Object from a file.
            Automotive FordZTW1 = fileio.buildAutoObject("FordZTW1.txt");
            // Print attributes before serialization
            FordZTW1.print();

            // Serialize the object
            fileio.serializeAuto(FordZTW1, "auto.ser");
            // Deserialize the object and read it into memory.
            Automotive newFordZTW1 = fileio.deserializeAuto("auto.ser");
            // Print new attributes.
            System.out.println("#################################");
            newFordZTW1.print();
        } catch (Exception e) {

        }
    }

}
