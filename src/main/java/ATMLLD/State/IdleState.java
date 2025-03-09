package ATMLLD.State;

import ATMLLD.AtmMachine;
import ATMLLD.Model.AtmCard;

public class IdleState extends State{
    public IdleState(){
        System.out.println("Atm is at idle state");
    }

    @Override
    public void insertCard(AtmMachine atmMachine, AtmCard atmCard){
        atmMachine.setState(new hasCardState(atmMachine, atmCard));
    }
}
