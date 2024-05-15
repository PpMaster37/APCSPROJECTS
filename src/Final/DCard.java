package Final;

import java.util.ArrayList;

public class DCard implements Card{
    private CheckingAccount linkedAcc;
    private ArrayList<String> cardActivities;
    private int pin;
    private String name;
    public DCard(CheckingAccount cA){
        linkedAcc = cA;
        name = linkedAcc.name;
    }
    public void use(int n, int p){
        if(p!=pin){
            System.out.println("Wrong pin");
        } else if(linkedAcc.getBalance()<n){
            System.out.println("Cannot overdraw");
        } else {
            linkedAcc.withdraw(n);
            String str = n + "withdrawn from account through card, Date:" + java.time.LocalDateTime.now();
            cardActivities.add(str);
            linkedAcc.activities.add(str);
        }
    }
    public void deposit(int n, int p){
        if(p!=pin){
            System.out.println("Wrong pin");
        } else {
            linkedAcc.deposit(n);
            String str = n + "deposited tp account through card, Date:" + java.time.LocalDateTime.now();
            linkedAcc.activities.add(str);
        }
    }
    public void changePin(int p, int n){
        if(pin == p){
            pin = n;
        } else {
            System.out.println("Wrong pin");
        }
    }
    public ArrayList<String> getActivities(){
        return cardActivities;
    }
}
