package VendingMachineLLD;

public class Item {
    public int cost;
    ItemType itemType;
    public Item(int cost, ItemType itemType){
        this.cost = cost;
        this.itemType = itemType;
    }
    public Item(){}


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
