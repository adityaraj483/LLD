package VendingMachineLLD;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemSelf> itemSelfes;
    int size;
    public Inventory(int n){
        this.itemSelfes = new ArrayList<>();
        this.size = n;
        initializeInventory();
    }

    public List<ItemSelf> getItemSelfes() {
        return itemSelfes;
    }

    public void setItemSelfes(List<ItemSelf> itemSelfes) {
        this.itemSelfes = itemSelfes;
    }

    private void initializeInventory() {
        int selfId = 101;
        for(int i=0;i<size;i++){
            ItemSelf itemSelf = new ItemSelf(selfId, null);
            itemSelfes.add(itemSelf);
            selfId++;
        }
    }

    public boolean isSoldOut(int selfId){
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == selfId){
                return itemSelf.isSoldOut();
            }
        }
        return true;
    }
    public void addItem(Item item, int selfId) throws Exception {
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == selfId){

                if(itemSelf.isSoldOut()){
                    itemSelf.setItem(item);
                    itemSelf.setSoldOut(false);
                }else
                    throw new Exception("Self is already full");
            }
        }
    }

    public Item getItem(int selfId) throws Exception {
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == selfId){
                if(itemSelf.isSoldOut()){
                    throw new Exception("Item is out of Stock");
                }else
                    return itemSelf.getItem();
            }
        }
        return null;
    }
    public void updateSoldOut(int selfId){
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == selfId){
                itemSelf.setSoldOut(true);
                return;
            }
        }
    }
}
