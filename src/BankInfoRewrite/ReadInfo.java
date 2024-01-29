package BankInfoRewrite;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Formatter;

public class ReadInfo {
    private static File data;
    private static String dataLine, firstName, lastName, bankOneAccount, bankOneBalance, bankTwoAccount, bankTwoBalance,
    bankOneOutput, bankTwoOutput;
    private static Scanner scr;
    public static boolean secondBank,isTwoAcc;
    public ReadInfo() throws IOException{
        //Constructor defines variables for later use
        data = new File("src/BankInfoRewrite/bankinfo.in");
        dataLine = " ";
        firstName = " ";
        lastName = " ";
        bankOneAccount = " ";
        bankOneBalance = " ";
        bankTwoAccount = " ";
        bankTwoBalance = " ";
        scr = new Scanner(data);
    }
    public static void read() throws IOException{
        dataLine = scr.nextLine();
        //Scanner to read line
        Scanner lineReader = new Scanner(dataLine);
        //Variables to store the name
        firstName = lineReader.next();
        lastName = lineReader.next();
        //If statement to determine which bank accounts person has and storing values in correct variables
        if (lineReader.next().equals("HSBC")){
            isTwoAcc = false;
            secondBank = false;
            bankOneAccount = lineReader.next();
            bankOneBalance = lineReader.next();
            if (lineReader.hasNext()){
                lineReader.next();
                isTwoAcc = true;
                bankTwoAccount = lineReader.next();
                bankTwoBalance = lineReader.next();
            }
        } else {
            isTwoAcc = false;
            secondBank = true;
            lineReader.next();
            bankTwoBalance = lineReader.next();
            bankTwoBalance = lineReader.next();
        }
        lineReader.close();
    }
    public static void formatLine(){
        Formatter fr = new Formatter();
        Formatter frSecond = new Formatter();
        //If statement to determine which variables to format
        if(isTwoAcc){
            //Formatting for both account one and two with corresponding variables
            String fullName = firstName + " " + lastName;
            fr.format("%-20s %-10s %-20s",fullName,bankOneAccount, bankOneBalance);
            bankOneOutput = fr.toString();
            fr.close();
            frSecond.format("%-20s %-10s %-20s",fullName,bankTwoAccount, bankTwoBalance);
            bankTwoOutput = frSecond.toString();
            frSecond.close();
        } else if (secondBank){
            //Formatting for only account two
            String fullName = firstName + " " + lastName;
            fr.format("%-20s %-10s %-20s",fullName,bankTwoAccount, bankTwoBalance);
            bankTwoOutput = fr.toString();
        } else{
            //Formatting for only account one
            String fullName = firstName + " " + lastName;
            fr.format("%-20s %-10s %-20s",fullName,bankOneAccount, bankOneBalance);
            bankOneOutput = fr.toString();
        }
    }
    //Getter methods
    public static String getOneOutput(){
        return bankOneOutput;
    }
    public static String getTwoOutput(){
        return bankTwoOutput;
    }
}
