package Final;

import java.util.ArrayList;

public class BankAccount {
    protected int accountNumber;
    protected String name;
    protected int balance;
    protected ArrayList<String> activities;
    public BankAccount(int aN, String n){
        accountNumber = aN;
        name = n;
    }
    public void deposit(int n){
        balance+=n;
        System.out.println(n + "deposited into " + name + "'s account");
        String str = n + "deposited into account directly, Date:" + java.time.LocalDateTime.now();
        activities.add(str);
    }
    public void withdraw(int n){
        if(n>balance){
            System.out.println("Cannot overdraw");
        } else {
            balance-=n;
            System.out.println(n + "withdrawn from " + name + "'s account");
            String str = n + "withdrawn from account directly, Date:" + java.time.LocalDateTime.now();
            activities.add(str);
        }
    }
    public int getBalance(){
        return balance;
    }
}
