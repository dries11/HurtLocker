package ries.dan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/8/17.
 */
public class JerkSonParserTest {

    String[] arrayOfGroceryItemsInString = new String[]{"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016","naME:BreaD;price:1.23;type:Food;expiration:1/02/2016","NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};

    JerkSonParser jerkSonParser = new JerkSonParser();

    String[] splitStrings;

    @Test
    public void splitFileIntoPartsTest(){
        String[] actual = jerkSonParser.splitFileIntoParts("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
        assertTrue(actual.length == 3);
    }

    @Before public void initialize(){
        splitStrings = jerkSonParser.splitFileIntoParts("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
    }

    @Test
    public void parseStringsTEST(){
        int expected = 3;
        int actual = jerkSonParser.parseStrings(splitStrings).size();
        assertTrue(actual == expected);
    }

    @Test
    public void parseStringsInformationTEST(){
        String expected = "1.23";
        String[] returned = jerkSonParser.parseStrings(splitStrings).get(0);
        String actual = returned[1];
        assertEquals("We expect to get the price of the bread back",expected,actual);
    }



}
