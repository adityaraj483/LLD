package VendingMachineLLD;


public class ItemSelf {
    Item item;
    int selfId;
    Boolean soldOut;
    ItemSelf(int selfId, Item item){
        this.item = item;
        this.selfId = selfId;
        this.soldOut = false;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public Boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(Boolean soldOut) {
        this.soldOut = soldOut;
    }
}
