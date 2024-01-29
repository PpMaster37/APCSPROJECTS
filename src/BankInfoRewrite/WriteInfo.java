package BankInfoRewrite;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class WriteInfo {
    //Class and method for outputting information
    public static void write() throws IOException {
        if(ReadInfo.isTwoAcc){
            //Outputs the first bank account information for the person in output file one
            FileWriter out = new FileWriter("src/BankInfoRewrite/bankOne.out",true);
            PrintWriter printer = new PrintWriter(out);
            printer.println(ReadInfo.getOneOutput());
            out.close();
            printer.close();
            //Outputs the second bank account information for the person in output file two
            FileWriter outSecond = new FileWriter("src/BankInfoRewrite/bankTwo.out",true);
            PrintWriter printerSecond = new PrintWriter(outSecond);
            printerSecond.println(ReadInfo.getTwoOutput());
            outSecond.close();
            printerSecond.close();
        } else if (ReadInfo.secondBank){
            //Outputs the person's second bank account information in output file two
            FileWriter outSecond = new FileWriter("src/BankInfoRewrite/bankTwo.out",true);
            PrintWriter printerSecond = new PrintWriter(outSecond);
            printerSecond.println(ReadInfo.getTwoOutput());
            outSecond.close();
            printerSecond.close();
        } else {
            //Outputs the first account information for the person in output file one
            FileWriter out = new FileWriter("src/BankInfoRewrite/bankOne.out",true);
            PrintWriter printer = new PrintWriter(out);
            printer.println(ReadInfo.getOneOutput());
            out.close();
            printer.close();
        }
    }
}
