package VendingMachineLLD;

import VendingMachineLLD.State.IState;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try{
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            IState state = vendingMachine.getState();

            state.ClickOnInsertCoinButton(vendingMachine);

            state = vendingMachine.getState();
            vendingMachine.addCoin(10);
            vendingMachine.addCoin(20);

            state.clickOnProductSelectionButton(vendingMachine);
            state = vendingMachine.getState();

            state.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);


        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        List<ItemSelf> slots = vendingMachine.getInventory().getItemSelfes();
        for (int i = 0; i < slots.size(); i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setItemType(ItemType.Coke);
                newItem.setCost(12);
            }else if(i >=3 && i<5){
                newItem.setItemType(ItemType.Pepsi);
                newItem.setCost(9);
            }else if(i >=5 && i<7){
                newItem.setItemType(ItemType.Juice);
                newItem.setCost(13);
            }else if(i >=7 && i<10){
                newItem.setItemType(ItemType.Soda);
                newItem.setCost(7);
            }
            slots.get(i).setItem(newItem);
            slots.get(i).setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        List<ItemSelf> slots = vendingMachine.getInventory().getItemSelfes();
        for (int i = 0; i < slots.size(); i++) {

            System.out.println("CodeNumber: " + slots.get(i).getSelfId() +
                    " Item: " + slots.get(i).getItem().getItemType().name() +
                    " Price: " + slots.get(i).getItem().getCost() +
                    " isAvailable: " + !slots.get(i).isSoldOut());
        }
    }

}
