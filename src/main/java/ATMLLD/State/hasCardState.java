package ATMLLD.State;

import ATMLLD.AtmMachine;
import ATMLLD.Model.AtmCard;

public class hasCardState extends State{
    AtmMachine atmMachine;
    AtmCard atmCard;
    public hasCardState(AtmMachine atmMachine, AtmCard atmCard) {
        System.out.println("HasCard state");
        this.atmMachine = atmMachine;
        this.atmCard = atmCard;
    }

    @Override
    public void authenticateCard(String pinCode ){
        if(pinCode.equals(atmCard.getPinCode()))
            atmMachine.setState(new ProcessState(atmMachine, atmCard));
        else {
            System.out.println("Incorrect pin");
            exit();
        }
    }

    @Override
    public void exit(){
        System.out.println("Exiting from atm machine, Please collect your card");
        atmMachine.setState(new IdleState());
    }
}
