package VendingMachineLLD.State;

import VendingMachineLLD.*;

import java.util.ArrayList;

public class HasMoneyState implements IState {
    public HasMoneyState(){
        System.out.println("Currently in HasMoney state");
    }
    @Override
    public void ClickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) {
        machine.setState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, int coin) {
        machine.addCoin(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public int getChange(int change) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public Item dispanceProduct(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not supported in this state");
    }


    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception {
        int sum = machine.getCoins().stream().reduce(0, Integer::sum);
        System.out.println("Refunding full money, "+ sum +" rupees in dispense trey");
        machine.setCoins(new ArrayList<>());
        machine.setState(new IdleState());
        return sum;
    }

    @Override
    public void updateInventory(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not supported");
    }
}
