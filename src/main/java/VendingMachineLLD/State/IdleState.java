package VendingMachineLLD.State;


import VendingMachineLLD.Item;
import VendingMachineLLD.VendingMachine;

public class IdleState implements IState{
    public IdleState(){
        System.out.println("Currently in Ideal state");
    }
    @Override
    public void ClickOnInsertCoinButton(VendingMachine machine) {
        System.out.println("Changing state to HasMoney state");
        machine.setState(new HasMoneyState());
    }

    @Override
    public int refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Not supported");
    }


    @Override
    public int getChange(int change) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public Item dispanceProduct(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void insertCoin(VendingMachine machine, int coin) throws Exception {
        throw new Exception("Not supported");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Not supported");
    }
    @Override
    public void updateInventory(VendingMachine machine, int productId) throws Exception {
        throw new Exception("Not Supported");
    }
}
