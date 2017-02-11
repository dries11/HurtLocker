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
    public void splitFileIntoPartsTEST(){
        String[] actual = jerkSonParser.splitFileIntoParts("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
        assertTrue(actual.length == 3);
    }

    @Test
    public void splitFileIntoPartsContentTEST(){
        String[] actual = jerkSonParser.splitFileIntoParts("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
        String expected = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016";
        assertEquals("We expect to get the right content for split",expected,actual[0]);
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

    @Before public void setUpErrorArray(){
        splitStrings = new String[]{"naMe:;price:3.23;type:Food;expiration:1/04/2016","naMe:MiLK;priCe:;type:Food;expiration:1/11/2016","naMe:;price:3.23;type:Food^expiration:1/04/2016","naMe:MilK;priCe:;type:Food;expiration:4/25/2016"};
    }

    @Test
    public void testForErrorParsing(){
        int expected = 4;
        jerkSonParser.parseStrings(splitStrings);
        int actual = jerkSonParser.getErrorCounter();
        assertEquals("We expect to get 4 errors",expected,actual);
    }

    @Test
    public void parseStringsCookiesPatternTEST(){
        String[] test = new String[]{"naMe:co0kies;pRice:2.25;type:Food;expiration:1/25/2016"};
        String expected = "cookies";
        String[] returned = jerkSonParser.parseStrings(test).get(0);
        String actual = returned[0];
        assertEquals("We expect to get cookies back instead of cO",expected,actual);
    }



}
