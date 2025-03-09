package VendingMachineLLD.State;

import VendingMachineLLD.Item;
import VendingMachineLLD.VendingMachine;

import javax.naming.event.EventContext;
import java.util.ArrayList;

public class DispenseState implements IState{
    DispenseState(VendingMachine machine, int productId) throws Exception {
        System.out.println("Currently in dispense state");
       dispanceProduct(machine, productId);
    }
    @Override
    public void ClickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void insertCoin(VendingMachine machine, int coin) throws Exception {
        throw new Exception("Not supported");
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
        Item item =  machine.getInventory().getItem(productId);

        System.out.println("Item dispensed successfully id : "+ productId + ", price : "+ item.getCost());
        machine.getInventory().updateSoldOut(productId);

        machine.setCoins(new ArrayList<>());
        machine.setState(new IdleState());
        return item;
    }


    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void updateInventory(VendingMachine machine, int productId) throws Exception {
       throw new Exception("Not supported");
    }
}
