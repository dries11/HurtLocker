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
            if (this.containsKey(item.name)){
                this.get(item.name).add(item);
            }
            else{
                ArrayList<GroceryItem> items = new ArrayList<GroceryItem>();
                items.add(item);
                this.put(item.name,items);
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
                    String name = itemInfo[0];
                    String price = itemInfo[1];
                    String type = itemInfo[2];
                    String expiration = itemInfo[3];
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


}
