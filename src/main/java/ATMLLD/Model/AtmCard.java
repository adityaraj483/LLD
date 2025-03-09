package ATMLLD.Model;

public class AtmCard {
    String pinCode;
    BankAccount account;
    public AtmCard(String pinCode, BankAccount account){
        this.pinCode = pinCode;
        this.account = account;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}
