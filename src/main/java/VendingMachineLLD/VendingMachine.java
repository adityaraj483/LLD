package VendingMachineLLD;

import VendingMachineLLD.State.IState;
import VendingMachineLLD.State.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    List<Item> items;
    IState state;
    List<Integer> coins;
    Inventory inventory;
    VendingMachine(){
        state = new IdleState();
        items = new ArrayList<>();
        coins = new ArrayList<>();
        inventory = new Inventory(10);
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

    public List<Item> getItems(){
        return items;
    }

    public Item getItem(int productId) {
        for (ItemSelf itemSelf : inventory.getItemSelfes())
            if(itemSelf.getSelfId() == productId)
                return itemSelf.getItem();
        return null;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
