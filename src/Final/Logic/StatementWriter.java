package Final.Logic;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class StatementWriter {
    private final File file = new File("/Users/dantang/IdeaProjects/APCompSci/src/Final/statementBuffer.txt");
    public StatementWriter(){

    }
    public void writeStatement(BankAccount account){
        String accname = account.name;
        String bankName = account.parentBank.getName();
        String address = account.parentBank.getAddress();
        int id = account.accountNumber;
        int totalInterest = account.calculateInterest(account.getCreationDate(), LocalDateTime.now());
        String act = formatActivities(account.getActivities());
        try {
            FileWriter fw = new FileWriter(file);
            PrintWriter printer = new PrintWriter(fw);
            fw.write(" ");
            printer.println(accname);
            printer.println(id);
            printer.println(bankName);
            printer.println(address);
            printer.println(totalInterest);
            printer.println(act);
            printer.close();
            fw.close();
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Womp");
        }
    }
    public void writeStatement(DCard card){
        String act = formatActivities(card.getActivities());
        String name = card.getName();
        try{
            FileWriter fw = new FileWriter(file);
            PrintWriter printer = new PrintWriter(fw);
            fw.write(" ");
            printer.println(name);
            printer.println(act);
            printer.close();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("WOMP");
        }
    }
    public void writeStatement(CCard card){
        String act = formatActivities(card.getActivities());
        String name = card.getName();
        String bankName = card.getBankName();
        String tier = String.valueOf(card.getTier());
        try{
            FileWriter fw = new FileWriter(file);
            PrintWriter printer = new PrintWriter(fw);
            fw.write(" ");
            printer.println(name);
            printer.println(bankName);
            printer.println(tier);
            printer.println(act);
            printer.close();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("WOMP");
        }
    }
    public String formatActivities(ArrayList<String> activities){
        String output = "";
        for(String str:activities){
            output += str;
            output += "\n";
        }
        return output;
    }
    public String getCurrentStatement(){
        try{
            String str = "";
            Scanner scr = new Scanner(file);
            scr.useDelimiter("\n");
            while(scr.hasNext()){
                str += scr.next();
                str += "\n";
            }
            return str;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("WOMPWOMP");
        }
        return "Error";
    }
}
