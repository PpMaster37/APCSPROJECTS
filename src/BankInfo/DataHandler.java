package BankInfo;

import java.io.IOException;
import java.util.Scanner;
import java.util.Formatter;

public class DataHandler {
    public static void lineReader(int lineNumber){
        Scanner lineScanner = new Scanner(ArrayHandler.dataLines.get(lineNumber));
        int count = -1;
        ArrayHandler.dataLine.set(5," ");
            while(lineScanner.hasNext()){
                count++;
                ArrayHandler.dataLine.set(count,lineScanner.next());
        }
    }
    //Method to check if person has two accounts
    public static boolean isTwoAccount(int lineNumber){
        boolean twoAccount = false;
        ReadInfo.readFile("src/BankInfo/bankinfo.in");
        DataHandler.lineReader(lineNumber);
        if(ArrayHandler.dataLine.get(5).equals("HSBL")){
            twoAccount = true;
        }
        return twoAccount;
    }
    //Method to format person's account one data
    public static String bankOneAcc(){
        Formatter fmt = new Formatter();
        fmt.format("%-20s %-10s %-16s ", ArrayHandler.dataLine.get(0) + " " + ArrayHandler.dataLine.get(1),
                ArrayHandler.dataLine.get(3),ArrayHandler.dataLine.get(4));
        return fmt.toString();
    }
    //Method to format person's account two data
    public static String bankTwoAcc(){
        Formatter fmt = new Formatter();
        fmt.format("%-20s %-15s %-16s ", ArrayHandler.dataLine.get(0) + " " + ArrayHandler.dataLine.get(1),
                ArrayHandler.dataLine.get(6),ArrayHandler.dataLine.get(7));
        return fmt.toString();
    }
}
