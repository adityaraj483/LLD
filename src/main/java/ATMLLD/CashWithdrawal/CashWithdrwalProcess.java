package ATMLLD.CashWithdrawal;

import ATMLLD.AtmMachine;

public abstract class CashWithdrwalProcess {
    CashWithdrwalProcess nextCashWithdrwalProcess;
    public CashWithdrwalProcess(CashWithdrwalProcess cashWithdrwalProcess){
        this.nextCashWithdrwalProcess = cashWithdrwalProcess;
    }

    public void withdraw(AtmMachine atmMachine, int amount){
        if(nextCashWithdrwalProcess != null){
            nextCashWithdrwalProcess.withdraw(atmMachine, amount);
        }else
            System.out.println("Sum amount is not present in Atm Machine");
    }

}
