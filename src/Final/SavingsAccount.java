package Final;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SavingsAccount extends BankAccount{
    private int interestRate;
    private Bank bank;
    private LocalDateTime creationDate;
    public SavingsAccount(int aN, String n, Bank bank, LocalDateTime date){
        super(aN,n);
        this.bank = bank;
        creationDate = date;
    }
}
