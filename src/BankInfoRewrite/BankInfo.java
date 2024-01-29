package BankInfoRewrite;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class BankInfo {
    public static void main(String[] args) throws IOException {
        File data = new File("src/BankInfoRewrite/bankinfo.in");
        Scanner scr = new Scanner(data);
        //Making scanner and file for while loop which runs through people's information
        ReadInfo x = new ReadInfo();
        //Creates object for constructor values
        while(scr.hasNextLine()){
            /*Methods to read information, then to format it and then output according to how many accounts
            they have*/
            x.read();
            x.formatLine();
            WriteInfo.write();
            scr.nextLine();
            //nextLine advances scanner for the while loop
        }
        scr.close();
    }
}
