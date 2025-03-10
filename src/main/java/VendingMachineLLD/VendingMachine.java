package VendingMachineLLD;

import VendingMachineLLD.State.IState;
import VendingMachineLLD.State.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    IState state;
    List<Integer> coins;
    Inventory inventory;
    VendingMachine(int size ){
        state = new IdleState();
        coins = new ArrayList<>();
        inventory = new Inventory(size);
    }
    public void setState(IState newState){
        this.state = newState;
    }

    public List<Integer> getCoins() {
        return coins;
    }

    public void setCoins(List<Integer> coins) {
        this.coins = coins;
    }

    public void addCoin(int coin){
        coins.add(coin);
    }

    public Item getItem(int productId) {
        for (ItemSelf itemSelf : inventory.getItemSelfes())
            if(itemSelf.getSelfId() == productId)
                return itemSelf.getItem();
        return null;
    }

    public IState getState() {
        return state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
