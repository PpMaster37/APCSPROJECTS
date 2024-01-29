package BankInfo;
import java.io.*;
//This class contains methods to print strings onto output files
public class WriteInfo {
    //This method prints to the first bank output file
    public static void filePrint(String line) throws IOException {
        try {
            FileWriter fw = new FileWriter("src/BankInfo/bankOne.out",true);
            PrintWriter output = new PrintWriter(fw);
            output.println(line);
            output.close();
            fw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error 1");
            e.getStackTrace();
        }
    }
    //This method prints to the second bank output file
    public static void filePrintTwo(String line) throws IOException{
        try {
            FileWriter fw = new FileWriter("src/BankInfo/bankTwo.out",true);
            PrintWriter output = new PrintWriter(fw);
            output.println(line);
            output.close();
            fw.close();

        }
        catch(FileNotFoundException e){
            System.out.println("Error 2");
            e.getStackTrace();
        }
    }

}
