package ATMLLD.Model;

public class User {
    String id;
    BankAccount account;
    AtmCard card;
    public User(String id, BankAccount account, AtmCard card){
        this.id = id;
        this.account = account;
        this.card = card;
    }


}
