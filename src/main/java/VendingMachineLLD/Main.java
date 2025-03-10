package VendingMachineLLD;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
            VendingMachine vendingMachine = new VendingMachine(12);
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            vendingMachine.getState().ClickOnInsertCoinButton(vendingMachine);

            vendingMachine.addCoin(10);
            vendingMachine.addCoin(20);

            vendingMachine.getState().clickOnProductSelectionButton(vendingMachine);


            vendingMachine.getState().chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);


        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        List<ItemSelf> itemSelfs = vendingMachine.getInventory().getItemSelfes();
        for (int i = 0; i < itemSelfs.size(); i++) {
            Item newItem = new Item();
            if(i<3) {
                newItem.setItemType(ItemType.Coke);
                newItem.setCost(12);
            }else if(i<5){
                newItem.setItemType(ItemType.Pepsi);
                newItem.setCost(9);
            }else if(i<7){
                newItem.setItemType(ItemType.Juice);
                newItem.setCost(13);
            }else if(i<10){
                newItem.setItemType(ItemType.Soda);
                newItem.setCost(7);
            }
            itemSelfs.get(i).setItem(newItem);
            itemSelfs.get(i).setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        List<ItemSelf> itemSelfes = vendingMachine.getInventory().getItemSelfes();
        for (ItemSelf itemSelfe : itemSelfes) {

            System.out.println("CodeNumber: " + itemSelfe.getSelfId() +
                    " Item: " + itemSelfe.getItem().getItemType().name() +
                    " Price: " + itemSelfe.getItem().getCost() +
                    " isAvailable: " + !itemSelfe.isSoldOut());
        }
    }

}
