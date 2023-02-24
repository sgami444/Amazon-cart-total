package com.amazon.test.framework.checkCartTotal;

import com.amazon.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class TestCartTotal extends TestBase {
    private SoftAssert sa = new SoftAssert();

    @Test(dataProvider = "provideData")
    public void testAmazonCart(String itemList){
        System.out.println("Start of the test Framework");
        String[] items = itemList.split(",");
        System.out.println("Items Are: " + Arrays.toString(items));
        for(String item : items){
            homePage.searchForItem(item);
            productPage.addToCart();
            //  Run a loop for adding items in cart
        }
        //  Check if the total in the cart matches the total shown in cart, check for duplicate items too
            // Probably can store this in some boolean, or s=directly give this as a condition below
        //  Do Assert.assertTrue(condition)
        Double[] priceInCart = cartPage.checkTotalInCart();
        //  0: Shown in total. 1: Calculated Total
        sa.assertEquals(priceInCart[0], priceInCart[1]);
        sa.assertAll();
    }
    @DataProvider
    public Object[][] provideData(){
        return new Object[][] {{"Bike, Watch, Toy"}, {"Hat, Pop up, plushy"}, {"Cap, racket, pen"}, {"Glasses, cup"}};
    }


}
