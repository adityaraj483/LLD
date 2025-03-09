package ATMLLD.State;

import ATMLLD.AtmMachine;
import ATMLLD.Model.AtmCard;

public abstract class State {
    public void insertCard(AtmMachine atmMachine, AtmCard card){
        System.out.println("Operation is not supported");
    }

    public void authenticateCard(String pinCode){
        System.out.println("Operation is not supported");
    }
    public void checkBalance(){
        System.out.println("Operation is not supported");
    }

    public void withdraw(int amount){
        System.out.println("Operation is not supported");
    }
    public void exit(){
        System.out.println("Operation not supported");
    }
}
