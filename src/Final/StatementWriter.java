package Final;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class StatementWriter {
    private final File file = new File("/Users/dantang/IdeaProjects/APCompSci/src/Final/statementBuffer.txt");
    public StatementWriter(){

    }
    public void writeStatement(BankAccount account) throws IOException {
        String accname = account.name;
        String bankName = account.parentBank.getName();
        String address = account.parentBank.getAddress();
        int id = account.accountNumber;
        int totalInterest = account.calculateInterest(account.getCreationDate(), LocalDateTime.now());
        String act = formatActivities(account.getActivities());
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
    }
    public void writeStatement(DCard card){
        String act = formatActivities(card.getActivities());
    }
    public void writeStatement(CCard card){

    }
    public String formatActivities(ArrayList<String> activities){
        String output = "";
        for(String str:activities){
            output += str;
            output += "\n";
        }
        return output;
    }
}
