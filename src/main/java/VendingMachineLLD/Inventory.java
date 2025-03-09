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
        int id = 101;
        for(int i=0;i<size;i++){
            ItemSelf itemSelf = new ItemSelf(id, null);
            itemSelfes.add(itemSelf);
            id++;
        }
    }

    public boolean isSoldOut(int id){
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == id){
                return itemSelf.isSoldOut();
            }
        }
        return true;
    }
    public void addItem(Item item, int id) throws Exception {
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == id){

                if(itemSelf.isSoldOut()){
                    itemSelf.setItem(item);
                    itemSelf.setSoldOut(false);
                }else
                    throw new Exception("Self is already full");
            }
        }
    }

    public Item getItem(int id) throws Exception {
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == id){
                if(itemSelf.isSoldOut()){
                    throw new Exception("Item is out of Stock");
                }else
                    return itemSelf.getItem();
            }
        }
        return null;
    }
    public void updateSoldOut(int id){
        for(ItemSelf itemSelf : itemSelfes){
            if(itemSelf.getSelfId() == id){
                itemSelf.setSoldOut(true);
                return;
            }
        }
    }
}
