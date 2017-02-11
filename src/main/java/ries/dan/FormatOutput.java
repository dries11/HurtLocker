package ries.dan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by danries on 2/8/17.
 */
public class FormatOutput {

//    String breakline = "============";
//
//    public String format(ArrayList<String[]> input){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(input);
//        Formatter formatter = new Formatter(stringBuilder);
//        formatter.format("%-30.30s %-30.30s");
//        return stringBuilder.toString();
//    }

    public void output(HashMap<String, ArrayList<GroceryItem>> data) throws IOException {

        ArrayList<String> prices;
        TreeMap<String, Integer> priceAndTimesSeen;
        ArrayList<GroceryItem> items;


        for (String key : data.keySet()){

            items = new ArrayList<GroceryItem>();
            items = data.get(key);
            System.out.println(key + " " + "Seen: " + items.size() + " times");
            prices = new ArrayList<String>();

            for (GroceryItem item : items)
                prices.add(item.getPrice());
            priceAndTimesSeen = new TreeMap<String, Integer>();

            for (int j = 0; j < prices.size(); j++){
                if (priceAndTimesSeen.containsKey(prices.get(j))){
                    int times = priceAndTimesSeen.get(prices.get(j));
                    times++;
                    priceAndTimesSeen.put(prices.get(j),times);
                }
                else{
                    priceAndTimesSeen.put(prices.get(j),1);
                }
            }

            for (String price : priceAndTimesSeen.keySet()){
                System.out.println(price + " " + "Seen: " + priceAndTimesSeen.get(price));
            }
        }
//        for (GroceryItem item : milk){
//            prices.add(item.getPrice());
//        }
//
//        for (int i = 0; i < prices.size(); i++){
//
//        }
//
//        System.out.println("Milk" + " " + milk.size());
//        for (String key : priceAndTimesSeen.keySet()){
//            System.out.println(key + " " + priceAndTimesSeen.get(key));
//        }

//        for (String name : data.keySet()){
//            timesSeen = data.get(name).size();
//            for (GroceryItem item : data.get(name)){
//                if (prices.containsKey(item.getPrice())){
//                    int numberOfTimesPriceSeen = prices.get(item.getPrice());
//                    numberOfTimesPriceSeen++;
//                    prices.put(item.getPrice(),numberOfTimesPriceSeen);
//                }
//                else{
//                    prices.put(item.getPrice(),1);
//                }
//            }
//        }

    }

}
