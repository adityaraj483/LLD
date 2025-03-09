package VendingMachineLLD.State;

import VendingMachineLLD.Item;
import VendingMachineLLD.VendingMachine;

public class SelectionState implements IState {
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
        int sumOfMoney = machine.getCoins().stream().reduce(0, Integer::sum);
        Item item = machine.getItem(productId);
        if(item == null)
            throw new Exception("Item not found");
        if(item.cost > sumOfMoney){
            refundFullMoney(machine);
            throw new Exception("Insufficient Money");
        }
        else if(item.cost < sumOfMoney) {
            getChange(sumOfMoney - item.cost);
        }

        machine.setState(new DispenseState(machine, productId));
    }

    @Override
    public int getChange(int change) throws Exception {
        System.out.println("Returning amount "+ change +" rupees to dispense tray");
        return change;
    }

    @Override
    public Item dispanceProduct(VendingMachine machine, int productId) throws Exception {
        return null;
    }


    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception {
        int sumMoney = machine.getCoins().stream().reduce(0, Integer::sum);
        System.out.println("Refunding full money "+ sumMoney +" rupees to dispense tray");
        return sumMoney;
    }

    @Override
    public void updateInventory(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not Supported");
    }
}
