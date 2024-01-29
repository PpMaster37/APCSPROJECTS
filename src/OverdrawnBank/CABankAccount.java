package OverdrawnBank;

public class CABankAccount extends BankAccount {
    private double balance;
    private String name;
    private double rate = 0.03;
    private String type;

    public CABankAccount(double a, String b){
        super(a,b);
        balance = a;
        name = b;
    }
    public void setupRate(double z){
        rate = z;
    }
    public void monthBalance(){
        balance = balance*rate+balance;
    }

}
