package VendingMachineLLD.State;

import VendingMachineLLD.*;

public interface IState {
    void ClickOnInsertCoinButton(VendingMachine machine) throws Exception;
    void clickOnProductSelectionButton(VendingMachine machine) throws Exception;
    void insertCoin(VendingMachine machine, int coin) throws Exception;

    void chooseProduct(VendingMachine machine, int productId) throws Exception;
    int getChange(int change) throws Exception;
    Item dispanceProduct(VendingMachine machine, int productId) throws Exception;
    int refundFullMoney(VendingMachine machine) throws Exception;
    void updateInventory(VendingMachine machine, int productId) throws Exception;
}
