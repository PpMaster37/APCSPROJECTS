package OverdrawnBank;

public class BankAccount {
    private double balance;
    private String name;

    public BankAccount(double a, String b){
        balance = a;
        name = b;
    }
    public void deposit(double x){
        balance += x;
    }
    public void withdraw(double y){
        balance -= y;
    }
    public double getBalance(){
        return balance;
    }
    public void print(){
        System.out.println("The "+name+" account balance is, $"+balance);
    }
}
