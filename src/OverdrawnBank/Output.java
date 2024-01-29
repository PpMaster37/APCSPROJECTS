package OverdrawnBank;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
public class Output {
    public void printFile(CABankAccount account) throws IOException {
        FileWriter output= new FileWriter("src/OverDrawnBank/BankBalanceOutput.out");
        PrintWriter printer = new PrintWriter(output);
        printer.println(account.getBalance());
        output.close();
        printer.close();
    }
}
