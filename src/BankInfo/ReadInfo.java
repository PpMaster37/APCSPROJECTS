package BankInfo;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class ReadInfo {
//Method inputs lines of data into an arraylist
    public static void readFile(String filename){
        try {
            File inputData = new File(filename);
            Scanner scr = new Scanner(inputData);
            while(scr.hasNext()) {
                String line = scr.nextLine();
                ArrayHandler.dataLines.add(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error 3");
            e.getStackTrace();
        }
    }
}
