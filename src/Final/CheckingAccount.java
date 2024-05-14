package Final;

import java.util.ArrayList;

public class CheckingAccount extends BankAccount {
    private ArrayList<CCard> creditCards;
    private ArrayList<DCard> debitCards;
    public CheckingAccount(int aL, String n){
        super(aL,n);
    }
    public void createCard(){
        debitCards.add(new DCard(this));
    }
}
