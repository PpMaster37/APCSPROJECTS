package Final;

import Final.Logic.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class DataPersist {
    private HashSet<Bank> bankHashSet = new HashSet<>();
    private HashSet<BankAccount> accountHashSet = new HashSet<>();
    private HashSet<DCard> dCardHashSet = new HashSet<>();
    private HashSet<CCard> cCardHashSet = new HashSet<>();
    File database = new File("/Users/dantang/IdeaProjects/APCompSci/src/Final/Files/bankData.txt");
    public DataPersist(){
        updateSets();
    }
    public void updateDatabase(){
        //Overwrites text file, use every change to privates
        //DO ALL BANKS FIRST
        //THEN CREATE EACH ACCOUNT AND ADD TO BANK
        //THEN CREATE CARD AND ADD TO EACH BANK/ACCOUNT
        //SEPARATE CATEGORIES WITH <CATEGORY
        String data = "";
        data += "<BANKS";
        data += "\n";
        for(Bank bank:bankHashSet){
            data += bankToString(bank);
            data += "\n";
        }
        data += "<ACCOUNTS";
        data += "\n";
        for(BankAccount acc:accountHashSet){
            if(acc.type.equals("C")){
                CheckingAccount cA = (CheckingAccount) acc;
                data += checkingAccToStr(cA);
                data += "\n";
            } else if(acc.type.equals("S")){
                SavingsAccount sA = (SavingsAccount) acc;
                data += savingsAccToStr(sA);
                data += "\n";
            }
        }
        data += "<CARDS";
        data += "\n";
        for(CCard card:cCardHashSet){
            data += cardToStr(card);
            data += "\n";
        }
        for(DCard card:dCardHashSet){
            data += cardToStr(card);
            data += "\n";
        }
        data += "P";
        try{
            FileWriter fw = new FileWriter(database);
            PrintWriter printer = new PrintWriter(fw);
            printer.println(data);
            fw.close();
            printer.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Womp error");
        }
    }
    public void updateSets(){
        //Data from database into sets
        try{
            Scanner scr = new Scanner(database);
            scr.useDelimiter("<");
            String bankData = scr.next();
            String accountData = scr.next();
            String cardData = scr.next();
            Scanner bankScr = new Scanner(bankData);
            Scanner accScr = new Scanner(accountData);
            Scanner cardScr = new Scanner(cardData);
            bankScr.useDelimiter("\n");
            accScr.useDelimiter("\n");
            cardScr.useDelimiter("\n");
            cardScr.next();
            if(!bankHashSet.isEmpty()) {
                bankHashSet.removeAll(bankHashSet);
            }
            if(!accountHashSet.isEmpty()) {
                accountHashSet.removeAll(accountHashSet);
            }
            if(!cCardHashSet.isEmpty()) {
                cCardHashSet.removeAll(cCardHashSet);
            }
            if(!dCardHashSet.isEmpty()) {
                dCardHashSet.removeAll(dCardHashSet);
            }
            bankScr.next();
            while(bankScr.hasNext()){
                bankHashSet.add(strToBank(bankScr.next()));
            }
            while(accScr.hasNext()){
                String info = accScr.next();
                Scanner secondaryScr = new Scanner(info);
                String temp = secondaryScr.next();
                if(temp.equals("CHECK")){
                    CheckingAccount ca = strToCAccount(info);
                    accountHashSet.add(ca);
                    searchForBank(ca.getBankName()).devAddAcc(ca);
                } else if(temp.equals("SAVE")){
                    SavingsAccount sa = strToSAccount(info);
                    accountHashSet.add(sa);
                    searchForBank(sa.getBankName()).devAddAcc(sa);
                }
            }
            while(cardScr.hasNext()){
                String info = cardScr.next();
                Scanner sec = new Scanner(info);
                String temp = sec.next();
                if(temp.equals("C")){
                    CCard card = strToCCard(info);
                    cCardHashSet.add(card);
                    searchForBank(card.getBankName()).devAddCCard(card);
                } else if(temp.equals("D")){
                    DCard card = strToDCard(info);
                    dCardHashSet.add(card);
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Womp file error");
        }
    }
    public Bank strToBank(String str){
        Scanner scr = new Scanner(str);
        scr.useDelimiter("~~~");
        scr.next();
        String name = scr.next();
        String ad = scr.next();
        int iR = Integer.parseInt(scr.next());
        return Bank.devCreate(name,ad,iR);
    }
    public String bankToString(Bank bank){
        String name = bank.getName();
        String ad = bank.getAddress();
        String iR = String.valueOf(bank.getInterestRate());
        String output = "";
        output += "STARTPHRASE ~~~";
        output += name;
        output += "~~~";
        output += ad;
        output += "~~~";
        output += iR;
        return output;
    }
    public String checkingAccToStr(CheckingAccount checkingAccount){
        String output = "";
        output += "CHECK ~~~";
        output += String.valueOf(checkingAccount.getAccountNumber());
        output += "~~~";
        output += checkingAccount.getName();
        output += "~~~";
        output += String.valueOf(checkingAccount.getBalance());
        output += "~~~";
        output += String.valueOf(checkingAccount.getInterestRate());
        output += "~~~";
        String activities = "";
        for(String str: checkingAccount.getActivities()){
            activities += "~8~";
            activities += str;
        }
        output += activities;
        output += "~~~";
        output += checkingAccount.getBankName();
        output += "~~~";
        output += checkingAccount.getLastUpdated();
        output += "~~~";
        output += checkingAccount.getCreation();
        return output;
    }
    public String savingsAccToStr(SavingsAccount savingsAccount){
        String output = "";
        output += "SAVE ~~~";
        output += String.valueOf(savingsAccount.getAccountNumber());
        output += "~~~";
        output += savingsAccount.getName();
        output += "~~~";
        output += String.valueOf((savingsAccount.getBalance()));
        output += "~~~";
        output += String.valueOf((savingsAccount.getInterestRate()));
        output += "~~~";
        String activities = "";
        for(String str: savingsAccount.getActivities()){
            activities += "~8~";
            activities += str;
        }
        output += activities;
        output += "~~~";
        output += savingsAccount.getBankName();
        output += "~~~";
        output += savingsAccount.getLastUpdated();
        output += "~~~";
        output += savingsAccount.getCreation();
        output += "~~~";
        output += savingsAccount.getMaxWithdrawals();
        output += "~~~";
        output += savingsAccount.getWithdrawCount();
        output += "~~~";
        output += savingsAccount.getLastAccessMonth();
        return output;
    }
    public String cardToStr(Card card){
        String output = "";
        if(card.getType().equals("C")){
            CCard Ccard = (CCard) card;
            output += "C ";
            output += "~~~";
            output += Ccard.getName();
            output += "~~~";
            output += Ccard.getBankName();
            output += "~~~";
            output += Ccard.getBalance();
            output += "~~~";
            output += Ccard.getTier();
            output += "~~~";
            output += Ccard.getPin();
            output += "~~~";
            String activities = "";
            if(!Ccard.getActivities().isEmpty()){
                for(String str: Ccard.getActivities()){
                    activities += "~8~";
                    activities += str;
                }
            } else {
                activities += "~8~";
                activities += "Initial creation";
            }
            output += activities;
        } else if(card.getType().equals("D")){
            DCard dCard = (DCard) card;
            output += "D ";
            output += "~~~";
            output += dCard.getName();
            output += "~~~";
            output += dCard.getPin();
            output += "~~~";
            String activities = "";
            if(!dCard.getActivities().isEmpty()) {
                for (String str : dCard.getActivities()) {
                    activities += "~8~";
                    activities += str;
                }
            }else{
                activities += "~8~";
                activities += "Initial creation";
            }
            output += activities;
        }
        return output;
    }
    public CheckingAccount strToCAccount(String str){
        Scanner scr = new Scanner(str);
        scr.useDelimiter("~~~");
        scr.next();
        int id = Integer.parseInt(scr.next());
        String name = scr.next();
        int bal = Integer.parseInt(scr.next());
        String iR = scr.next();
        String activities = scr.next();
        String bankName = scr.next();
        String lastDate = scr.next();
        String createDate = scr.next();
        LocalDateTime lastdateTime = strToDate(lastDate);
        LocalDateTime createdateTime = strToDate(createDate);
        ArrayList<String> act = new ArrayList<>();
        Scanner actScr = new Scanner(activities);
        actScr.useDelimiter("~8~");
        while(actScr.hasNext()){
            act.add(actScr.next());
        }
        return CheckingAccount.devCreateCA(id, name, searchForBank(bankName), lastdateTime,
                bal, act, createdateTime);
    }
    public SavingsAccount strToSAccount(String str){
        Scanner scr = new Scanner(str);
        scr.useDelimiter("~~~");
        scr.next();
        int id = Integer.parseInt(scr.next());
        String name = scr.next();
        int bal = Integer.parseInt(scr.next());
        int iR = Integer.parseInt(scr.next());
        String activities = scr.next();
        String bankName = scr.next();
        String lastDate = scr.next();
        String createDate = scr.next();
        int max = Integer.parseInt(scr.next());
        int count = Integer.parseInt(scr.next());
        int lastM = Integer.parseInt(scr.next());
        LocalDateTime lastdateTime = strToDate(lastDate);
        LocalDateTime createdateTime = strToDate(createDate);
        ArrayList<String> act = new ArrayList<>();
        Scanner actScr = new Scanner(activities);
        actScr.useDelimiter("~8~");
        while(actScr.hasNext()){
            act.add(actScr.next());
        }
        return SavingsAccount.devCreateSA(id,name,searchForBank(bankName),createdateTime,max,act,lastdateTime, count,
                lastM,bal,iR);
    }
    public CCard strToCCard(String str){
        Scanner scr = new Scanner(str);
        scr.useDelimiter("~~~");
        scr.next();
        String name = scr.next();
        String bankName = scr.next();
        String bal = scr.next();
        String tier = scr.next();
        String pin = scr.next();
        String act = scr.next();
        Scanner second = new Scanner(act);
        second.useDelimiter("~8~");
        ArrayList<String> activities = new ArrayList<>();
        while(second.hasNext()){
            activities.add(second.next());
        }
        return CCard.devCreateCCard(Integer.parseInt(tier),searchForBank(bankName),name,Integer.parseInt(bal),
                activities, Integer.parseInt(pin));
    }
    public DCard strToDCard(String str){
        Scanner scr = new Scanner(str);
        scr.useDelimiter("~~~");
        scr.next();
        String name = scr.next();
        String pin = scr.next();
        String act = scr.next();
        Scanner second = new Scanner(act);
        second.useDelimiter("~8~");
        ArrayList<String> activities = new ArrayList<>();
        while(second.hasNext()){
            activities.add(second.next());
        }
        return DCard.devCreateDCard((CheckingAccount) searchForAccount(name), activities, Integer.parseInt(pin));
    }

    public HashSet<Bank> getBankHashSet() {
        return bankHashSet;
    }

    public HashSet<BankAccount> getAccountHashSet() {
        return accountHashSet;
    }

    public HashSet<CCard> getcCardHashSet() {
        return cCardHashSet;
    }

    public HashSet<DCard> getdCardHashSet() {
        return dCardHashSet;
    }
    public void addToBanks(Bank bank){
        bankHashSet.add(bank);
    }
    public void addToAccounts(BankAccount account){
        accountHashSet.add(account);
    }
    public void addToDCards(DCard dCard){
        dCardHashSet.add(dCard);
    }
    public void addToCCards(CCard card){
        cCardHashSet.add(card);
    }
    public void removeFromBanks(Bank bank){
        bankHashSet.remove(bank);
    }
    public void removeFromAccounts(BankAccount acc){
        accountHashSet.remove(acc);
    }
    public void removeFromdCard(Card card){
        dCardHashSet.remove(card);
    }
    public void removeFromCCards(Card card){
        cCardHashSet.remove(card);
    }
    public Bank searchForBank(String bankName){
        //Insert binary search for bank
        ArrayList<Bank> banks = sortBanks();
        int mid = banks.size()/2;
        int low = 0;
        int high = banks.size()-1;
        while(high>=low){
            if(banks.get(low).getName().equals(bankName)){
                return banks.get(low);
            }
            if(banks.get(mid).getName().compareTo(bankName)==0){
                return banks.get(mid);
            }
            if(banks.get(mid).getName().compareTo(bankName)<0){
                low = mid + 1;
                int temp = high + low;
                mid = temp / 2;
            } else {
                high = mid - 1;
                int temp = high + low;
                mid = temp / 2;
            }
        }
        return null;
    }
    public LocalDateTime strToDate(String str){
        Scanner scr = new Scanner(str);
        scr.useDelimiter(",");
        int day = Integer.parseInt(scr.next());
        int month = Integer.parseInt(scr.next());
        int year = Integer.parseInt(scr.next());
        return LocalDateTime.of(year, month, day, 0, 0);
    }
    public BankAccount searchForAccount(String search){
        //Insert binary search for account
        ArrayList<BankAccount> input = sortAccounts();
        int mid = input.size()/2;
        int low = 0;
        int high = input.size()-1;
        while(high>=low){
            if(input.get(mid).getName().compareTo(search)==0){
                return input.get(mid);
            }
            if(input.get(mid).getName().compareTo(search)<0){
                low = mid + 1;
                int temp = high + low;
                mid = temp / 2;
            } else {
                high = mid - 1;
                int temp = high + low;
                mid = temp / 2;
            }
        }
        return null;
    }
    public ArrayList<BankAccount> sortAccounts(){
        ArrayList<BankAccount> accList = new ArrayList<>(accountHashSet);
        ArrayList<BankAccount> result = new ArrayList<>();
        for(int i = 0; i<accList.size();i++){
            String low = accList.get(i).getName();
            BankAccount lowAcc = accList.get(i);
            for(int x = i; x<accList.size();x++){
                if(accList.get(x).getName().compareTo(low)<0){
                    String temp = low;
                    BankAccount tempAcc = lowAcc;
                    low = accList.get(x).getName();
                    lowAcc = accList.get(x);
                    accList.set(x,tempAcc);
                }
            }
            result.add(lowAcc);
        }
        return result;
    }
    public ArrayList<Bank> sortBanks(){
        ArrayList<Bank> accList = new ArrayList<>(bankHashSet);
        ArrayList<Bank> result = new ArrayList<>();
        for(int i = 0; i<accList.size();i++){
            String low = accList.get(i).getName();
            Bank lowB = accList.get(i);
            for(int x = i; x<accList.size();x++){
                if(accList.get(x).getName().compareTo(low)<0){
                    String temp = low;
                    Bank tempB = lowB;
                    low = accList.get(x).getName();
                    lowB = accList.get(x);
                    accList.set(x,tempB);
                }
            }
            result.add(lowB);
        }
        return result;
    }
}
