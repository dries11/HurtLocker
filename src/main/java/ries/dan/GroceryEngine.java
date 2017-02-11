package ries.dan;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by danries on 2/9/17.
 */
public class GroceryEngine extends HashMap<String,ArrayList<GroceryItem>>{

    int errorCounter = 0;

    public void insertItemsIntoMap(ArrayList<GroceryItem> groceryItems){
        for (GroceryItem item : groceryItems){
            if (this.containsKey(item.getName())){
                this.get(item.getName()).add(item);
            }
            else{
                ArrayList<GroceryItem> items = new ArrayList<GroceryItem>();
                items.add(item);
                this.put(item.getName(),items);
            }
        }
    }

    public ArrayList<GroceryItem> createGroceryItems(ArrayList<String[]> items) throws KeyNotAssociatedWithValueException {
        ArrayList<GroceryItem> groceryItems = new ArrayList<GroceryItem>();
        try {
            for (String[] itemInfo: items) {
                if (itemInfo.length != 4) {
                    throw new KeyNotAssociatedWithValueException();
                } else {
                    String name = itemInfo[0].toLowerCase();
                    String price = itemInfo[1].toLowerCase();
                    String type = itemInfo[2].toLowerCase();
                    String expiration = itemInfo[3].toLowerCase();
                    GroceryItem groceryItem = new GroceryItem(name, price, type, expiration);
                    groceryItems.add(groceryItem);
                }
            }
            return groceryItems;
        }
        catch (KeyNotAssociatedWithValueException e){
            errorCounter++;
        }
        return null;
    }

    public int getErrorCounter(){
        return this.errorCounter;
    }


//    public HashMap<String, ArrayList<String>> getPricesSeen(){
//
//        ArrayList<String> pricesSeen = new ArrayList<String>();
//        HashMap<String, ArrayList<String>> itemPrices = new HashMap<String, ArrayList<String>>();
//
//        for (String items : this.keySet()){
//            for (GroceryItem item : this.get(items)){
//                if (itemPrices.containsKey(items)){
//                    itemPrices.get(items).add(item.getPrice());
//                }
//                else{
//                    pricesSeen.add(item.getPrice());
//                    itemPrices.put(items,pricesSeen);
//                }
//            }
//
//        }
//        return itemPrices;
//    }
//
//    public HashMap<String, Integer> getTimesItemSeen(){
//        HashMap<String,Integer> timesSeen = new HashMap<String, Integer>();
//        for (String items : this.keySet()){
//            for (GroceryItem item : this.get(items)){
//                if (timesSeen.containsKey(items)){
//                    int times = timesSeen.get(items);
//                    times++;
//                    timesSeen.put(items,times);
//                }
//                else{
//                    timesSeen.put(items,1);
//                }
//            }
//        }
//        return timesSeen;
//    }
//
//    public HashMap<String, Integer> getTimesPricesSeen(){
//        HashMap<String, Integer> timesPricesSeen = new HashMap<String, Integer>();
//        for (String items : this.keySet()){
//            for (GroceryItem item : this.get(items)){
//                if (timesPricesSeen.containsKey(item.getPrice())){
//                    int times = timesPricesSeen.get(item.getPrice());
//                    times++;
//                    timesPricesSeen.put(item.getPrice(),times);
//                }
//                else{
//                    timesPricesSeen.put(item.getPrice(),1);
//                }
//            }
//        }
//        return timesPricesSeen;
//    }


}
