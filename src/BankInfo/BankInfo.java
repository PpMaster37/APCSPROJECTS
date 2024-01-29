package BankInfo;

import java.io.IOException;


public class BankInfo {
    public static void main(String[] args) throws IOException {
        //Inputting data from input file into arraylist
        ReadInfo.readFile("src/BankInfo/bankinfo.in");
        for(int b = 0; b<=8;b++){
            ArrayHandler.dataLine.add(" ");
        }
        //Loop to run through all lines of data
        for(int a = 1; a <= 20;a++) {
            DataHandler.lineReader(a);
            DataHandler.isTwoAccount(a);
            //If statement checks whether person has two accounts then outputs their info accordingly
            if (DataHandler.isTwoAccount(a)){
                WriteInfo.filePrint(DataHandler.bankOneAcc());
                WriteInfo.filePrintTwo(DataHandler.bankTwoAcc());
            }
            else {
                WriteInfo.filePrint(DataHandler.bankOneAcc());
            }
        }
    }
}
