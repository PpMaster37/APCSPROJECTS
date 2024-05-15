package Final;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CheckingAccount extends BankAccount {
    private ArrayList<CCard> creditCards;
    private ArrayList<DCard> debitCards;
    public CheckingAccount(int aL, String n, Bank bank, LocalDateTime date){
        super(aL,n, bank, date);
        lastUpdated = date;
    }
    public void createDebitCard(int pin){
        DCard newCard = new DCard(this);
        debitCards.add(newCard);
        newCard.changePin(1111,pin);
    }
    public void createCreditCard(int tier, int pin){
        CCard newCard = new CCard(tier, this.parentBank, name);
        creditCards.add(newCard);
        newCard.changePin(1111,pin);
    }
}
