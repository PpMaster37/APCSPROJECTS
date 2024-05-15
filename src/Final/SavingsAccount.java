package Final;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SavingsAccount extends BankAccount{
    private final int maxWithdrawals;
    private int withdrawCount;
    private int lastAccessMonth;
    public SavingsAccount(int aN, String n, Bank bank, LocalDateTime date, int max){
        super(aN,n, bank, date);
        lastUpdated = date;
        maxWithdrawals = max;
        withdrawCount = 0;
        lastAccessMonth = LocalDateTime.now().getMonthValue();
    }
    public void withdraw(int n){
        if(n>balance){
            System.out.println("Cannot overdraw");
        } else if(withdrawCount>maxWithdrawals){
            System.out.println("Cannot withdraw over limit");
        } else {
            if(LocalDateTime.now().getMonthValue()==lastAccessMonth){
                withdrawCount++;
            } else {
                withdrawCount = 0;
                lastAccessMonth = LocalDateTime.now().getMonthValue();
            }
            balance+=calculateInterest(lastUpdated, LocalDateTime.now());
            lastUpdated = LocalDateTime.now();
            balance-=n;
            System.out.println(n + "withdrawn from " + name + "'s account");
            String str = n + "withdrawn from account directly, Date:" + java.time.LocalDateTime.now();
            activities.add(str);
        }
    }
}
