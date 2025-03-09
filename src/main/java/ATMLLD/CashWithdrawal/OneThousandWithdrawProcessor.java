package ATMLLD.CashWithdrawal;

import ATMLLD.AtmMachine;

public class OneThousandWithdrawProcessor extends CashWithdrwalProcess{

    public OneThousandWithdrawProcessor(CashWithdrwalProcess cashWithdrwalProcess) {
        super(cashWithdrwalProcess);
    }

    @Override
    public void withdraw(AtmMachine atmMachine, int amount){
        int required1K = amount / 1000;
        int balance = amount % 1000;
        int countOf1k = atmMachine.getOneThousandRupeesCount();
        if(required1K <= countOf1k){
            atmMachine.setOneThousandRupeesCount(countOf1k - required1K);
        }else if(required1K > countOf1k) {
            balance = balance + (required1K - countOf1k) * 1000;
            atmMachine.setOneThousandRupeesCount(0);
        }

        if(balance != 0)
            super.withdraw(atmMachine, balance);
        else
            System.out.println("Please collect money");
    }
}
