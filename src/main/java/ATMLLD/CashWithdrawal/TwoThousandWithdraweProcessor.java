package ATMLLD.CashWithdrawal;

import ATMLLD.AtmMachine;
import ATMLLD.Model.AtmCard;

public class TwoThousandWithdraweProcessor extends CashWithdrwalProcess{
    public TwoThousandWithdraweProcessor(CashWithdrwalProcess cashWithdrwalProcess) {
        super(cashWithdrwalProcess);
    }

    @Override
    public void withdraw(AtmMachine atmMachine, int amount){
        int required2K = amount / 2000;
        int balance = amount % 2000;
        int countOf2k = atmMachine.getTwoThousandRupeesCount();
        if(required2K <= countOf2k){
            atmMachine.setTwoThousandRupeesCount(countOf2k - required2K);
        }else if(required2K > countOf2k) {
            balance = balance + (required2K - countOf2k) * 2000;
            atmMachine.setTwoThousandRupeesCount(0);
        }

        if(balance != 0)
            super.withdraw(atmMachine, balance);
        else
            System.out.println("Please collect money");
    }
}
