package util;

import model.*;
import java.io.*;

public class FileIO {
    public Automotive buildAutoObject(String filename) throws Exception {
        Automotive a = new Automotive();
        FileReader file = new FileReader(filename);
        BufferedReader buff = new BufferedReader(file);

        try {
            boolean eof = false;
            while (!eof) {
                String line = buff.readLine();
                if (line == null) {
                    eof = true;
                }
                if (line.equals("Model Name:")) {
                    String name = buff.readLine();
                    a.setName(name);
                }
                if (line.equals("Option set size:")) {
                    int num = Integer.parseInt(buff.readLine());
                    a.setOptionSetsize(num);
                }
                if (line.equals("Base price:")) {
                    float price = Float.parseFloat(buff.readLine());
                    a.setPrice(price);
                }
                if (line.equals("Option sets:")) {
                    for (int i = 0; i < a.getOptionSetsize(); i++) {
                        line = buff.readLine();
                        if (line.equals("Option set:")) {
                            String optsetName = buff.readLine();
                            int optSize = Integer.parseInt(buff.readLine());
                            a.setOptionSet(i, optsetName, optSize);
                            for (int j = 0; j < optSize; j++) {
                                String optionName = buff.readLine();
                                float price = Float.parseFloat(buff.readLine());
                                a.setOption(i, j, optionName, price);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            buff.close();
            // loading process completed
            System.out.println("Loading completed.");
            System.out.println();
        }
        return a;
    }

    public Automotive deserializeAuto(String filename) {
        Automotive a = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    filename));
            a = (Automotive) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
        return a;
    }

    public void serializeAuto(Automotive a, String filename) {
    	//Auto serialization
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(filename));
            out.writeObject(a);
            out.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
    }

}
