package Final.Logic;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccount {
    protected int accountNumber;
    protected String name;
    protected int balance;
    protected ArrayList<String> activities;
    protected int interestRate;
    protected LocalDateTime lastUpdated;
    private final LocalDateTime creationDate;
    protected Bank parentBank;
    public String type = "";
    public BankAccount(int aN, String n, Bank bank, LocalDateTime date){
        accountNumber = aN;
        name = n;
        interestRate = bank.getInterestRate();
        parentBank = bank;
        creationDate = date;
    }
    public void deposit(int n){
        balance+=calculateInterest(lastUpdated, LocalDateTime.now());
        lastUpdated = LocalDateTime.now();
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
    public int calculateInterest(LocalDateTime last, LocalDateTime now){
        if(last.getYear()!=now.getYear()){
            int years = last.getYear()-now.getYear()-1;
            int firstDays = 365 - last.getDayOfYear();
            int lastDays = now.getDayOfYear();
            int sum = years*365+firstDays+lastDays;
            int months = sum/30;
            return months*interestRate;
        } else {
            int months = now.getMonthValue()-last.getMonthValue();
            return months*interestRate;
        }
    }
    public int getBalance(){
        return balance;
    }
    public ArrayList<String> getActivities(){
        return activities;
    }
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
    public String getBankName(){
        return parentBank.getName();
    }
    public int getInterestRate(){
        return parentBank.getInterestRate();
    }
    public String getLastUpdated(){
        String day = String.valueOf(lastUpdated.getDayOfMonth());
        day += ",";
        day += String.valueOf(lastUpdated.getMonthValue());
        day += ",";
        day += String.valueOf(lastUpdated.getYear());
        return day;
    }
    public String getCreation(){
        String day = String.valueOf(creationDate.getDayOfMonth());
        day += ",";
        day += String.valueOf(creationDate.getMonthValue());
        day += ",";
        day += String.valueOf(creationDate.getYear());
        return day;
    }
}
