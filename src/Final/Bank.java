package Final;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bank {
    private String name;
    private String address;
    private int totalBalance;
    private int interestRate;
    private int loanInterest;
    private HashSet<BankAccount> accounts;
    private ArrayList<CCard> creditCards;

    public void createAccount(){
        System.out.println("What type of account, Checking or Savings:");
        Scanner scr = new Scanner(System.in);
        String accType = determineAcc(scr.nextLine());
        if(accType.equals("Check")){
            int count = 0;
            System.out.println("Please enter your name:");
            Scanner scrTwo = new Scanner(System.in);
            for (BankAccount account : accounts) {
                count++;
            }
            BankAccount checkAccount = new CheckingAccount(count,scrTwo.nextLine());
            accounts.add(checkAccount);
        } else if(accType.equals("Save")){
            int count = 0;
            System.out.println("Please enter your name:");
            Scanner scrTwo = new Scanner(System.in);
            for (BankAccount account : accounts) {
                count++;
            }
            BankAccount saveAccount = new SavingsAccount(count,scrTwo.nextLine(),this, LocalDateTime.now());
            accounts.add(saveAccount);
        }
    }
    public String determineAcc(String input){
        if(input.equals("Checking")||input.equals("checking")){
            return "Check";
        } else if(input.equals("Savings")||input.equals("savings")){
            return "Save";
        } else{
            System.out.println("Please enter either 'Checking' or 'Savings':");
            Scanner scr = new Scanner(System.in);
            return determineAcc(scr.nextLine());
        }
    }
    public void createCreditCard(){
        System.out.println("What tier card: ");
        Scanner scr = new Scanner(System.in);
        CCard credCard = new CCard(scr.nextInt());
        System.out.println("Please set a pin:");
        credCard.changePin(1111,scr.nextInt());
    }
    public ArrayList<BankAccount> getSortedAccountList(HashSet<BankAccount> accounts){
        ArrayList<BankAccount> sortedList = new ArrayList<>(accounts);
        ArrayList<BankAccount> result = new ArrayList<>();
        for(int i = 0; i<sortedList.size();i++){
            BankAccount low = sortedList.get(i);
            for(int x = i; x<sortedList.size();x++){
                if(sortedList.get(x).accountNumber<low.accountNumber){
                    BankAccount temp = low;
                    low = sortedList.get(x);
                    sortedList.set(x,temp);
                }
            }
            result.add(low);
        }
        return result;
    }
    public boolean searchForAccount(BankAccount acc){
        return true;
    }
}
