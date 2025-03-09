package ATMLLD.State;

import ATMLLD.AtmMachine;
import ATMLLD.CashWithdrawal.CashWithdrwalProcess;
import ATMLLD.CashWithdrawal.FiveHundredWithdrawProcessor;
import ATMLLD.CashWithdrawal.OneThousandWithdrawProcessor;
import ATMLLD.CashWithdrawal.TwoThousandWithdraweProcessor;
import ATMLLD.Model.AtmCard;

public class ProcessState extends State{
    AtmCard atmCard;
    AtmMachine atmMachine;
    public ProcessState(AtmMachine atmMachine, AtmCard atmCard){
        System.out.println("Process state");
        this.atmCard = atmCard;
        this.atmMachine = atmMachine;
    }
    @Override
    public void withdraw(int amount){
        if(atmMachine.getAmount() > amount){
            if(atmCard.getAccount().getBalance() > amount){

//                atmCard.getAccount().setBalance(atmCard.getAccount().getBalance() - amount);
//                System.out.println("Please collect "+amount+" rupees from tray");
                CashWithdrwalProcess process = new TwoThousandWithdraweProcessor(new OneThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(null)));
                process.withdraw(atmMachine, amount);
            }else{
                System.out.println("Insufficient balance in account");
            }
        }else{
            System.out.println("Insufficient amount in Atm Machine");
        }

        //exit();
    }

    @Override
    public void checkBalance(){
        System.out.println("Bank balance is "+ atmCard.getAccount().getBalance() +" rupees");
        //exit();
    }

    @Override
    public void exit(){
        System.out.println("Exiting from atm machine, Please collect your card");
        atmMachine.setState(new IdleState());
    }
}
