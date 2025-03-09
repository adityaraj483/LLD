package ATMLLD.CashWithdrawal;

import ATMLLD.AtmMachine;

public class FiveHundredWithdrawProcessor extends CashWithdrwalProcess{

    public FiveHundredWithdrawProcessor(CashWithdrwalProcess process){
        super(process);
    }
    @Override
    public void withdraw(AtmMachine atmMachine, int amount){

        int required500 = amount / 2000;
        int balance = amount % 2000;
        int countOf500 = atmMachine.getFiveHundredRupeesCount();
            if(required500 <= countOf500){
            atmMachine.setFiveHundredRupeesCount(countOf500 - required500);
        }else if(required500 > countOf500) {
            balance = balance + (required500 - countOf500) * 2000;
            atmMachine.setFiveHundredRupeesCount(0);
        }

        if(balance != 0) {
            super.withdraw(atmMachine, balance);
        }else
            System.out.println("Please collect money");
    }
}
