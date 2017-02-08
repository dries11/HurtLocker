package ries.dan;

/**
 * Created by danries on 2/8/17.
 */
public class GroceryItem {

    public String name;
    public String price;
    public String type;
    public String expirationDate;

    public GroceryItem(String name, String price, String type, String expirationDate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expirationDate = expirationDate;
    }
}
