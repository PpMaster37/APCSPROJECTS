package Final.Logic;

import java.util.ArrayList;

public class CCard implements Card{
    private int tier;
    private int pin = 1111;
    private ArrayList<String> activities = new ArrayList<>();
    private int borrow;
    private int balance;
    private String name;
    private Bank parentBank;
    private String type = "C";
    public CCard(int t, Bank bank, String n){
        switch (t){
            case 1: borrow = 500;
            break;
            case 2: borrow = 1000;
            break;
            case 3: borrow = 5000;
            break;
            case 4: borrow = 10000;
            break;
            case 5: borrow = 100000;
            break;
        }
        parentBank = bank;
        name = n;
    }
    public void use(int n, int p){
        if(p!=pin){
            System.out.println("Wrong pin");
        } else if(balance<n){
            System.out.println("Cannot overdraw");
        } else {
            balance -= n;
            String str = n + "withdrawn from card, Date:" + java.time.LocalDateTime.now();
            activities.add(str);
        }
    }
    public void changePin(int p, int n){
        if(pin == p){
            pin = n;
        } else {
            System.out.println("Wrong pin");
        }
    }
    public void repay(int n){
        if(balance+n>borrow){
            int ret = n - (borrow-balance);
            balance = borrow;
            System.out.println(ret + "returned");
        } else{
            balance += n;
        }
    }
    public ArrayList<String> getActivities(){
        return activities;
    }
    public static CCard devCreateCCard(int t, Bank bank, String n, int balance, ArrayList<String> activities, int pin){
        CCard card = new CCard(t, bank, n);
        card.balance = balance;
        card.activities = activities;
        card.pin = pin;
        return card;
    }
    public boolean checkPin(int p) {
        return p == pin;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getBankName(){
        return parentBank.getName();
    }

    public int getBalance() {
        return balance;
    }

    public int getBorrow() {
        return borrow;
    }

    public int getPin() {
        return pin;
    }

    public int getTier() {
        return tier;
    }
}
