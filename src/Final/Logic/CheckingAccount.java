package Final.Logic;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CheckingAccount extends BankAccount {
    private ArrayList<DCard> debitCards;
    public CheckingAccount(int aL, String n, Bank bank, LocalDateTime date){
        super(aL,n, bank, date);
        lastUpdated = date;
        type = "C";
    }
    public static CheckingAccount devCreateCA(int aL, String n, Bank bank, LocalDateTime date, int bal,
                                              ArrayList<String> act, LocalDateTime lastDate){
        CheckingAccount account = new CheckingAccount(aL,n,bank,date);
        account.balance = bal;
        account.activities = act;
        account.lastUpdated = lastDate;
        return account;
    }
}
