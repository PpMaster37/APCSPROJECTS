package OverdrawnBank;


public class Tester {
    public static void main(String[] args)  {
        BankAccount myAccount = new CABankAccount(1000,"Person");
        myAccount.deposit(505.22);
        System.out.println(myAccount.getBalance());
        myAccount.withdraw(100);
        myAccount.print();
    }
}
