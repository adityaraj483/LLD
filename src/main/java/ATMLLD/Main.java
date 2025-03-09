package ATMLLD;

import ATMLLD.Model.AtmCard;
import ATMLLD.Model.BankAccount;
import ATMLLD.State.IdleState;

public class Main {
    public static void main(String[] args) {
        AtmMachine atmMachine = new AtmMachine(new IdleState(), 5000);
        atmMachine.setFiveHundredRupeesCount(3);
        atmMachine.setTwoThousandRupeesCount(1);
        atmMachine.setOneThousandRupeesCount(1);

        atmMachine.getState().insertCard(atmMachine, new AtmCard("1234", new BankAccount("1234", 4000)));
        atmMachine.getState().authenticateCard("1234");
        atmMachine.getState().checkBalance();
        atmMachine.getState().withdraw(3000);
        atmMachine.getState().withdraw(3000);
    }
}
