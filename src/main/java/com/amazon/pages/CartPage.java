package com.amazon.pages;

import com.amazon.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends TestBase {

    private By cartButton = By.cssSelector("#nav-cart");
    private By itemCost = By.cssSelector("div[data-name='Active Items'] div[data-itemtype]");
    private By totalCostElement = By.cssSelector("#sc-subtotal-amount-activecart > span");
    private List<Double> itemCostDouble = new ArrayList<>();
    private String dataPriceAttribute = "data-price";
    private String totalCost;
    private double sum = 0;

    List<WebElement> cartItems;


    public CartPage(WebDriver driver){
        this.driver = driver;   // Every subclass we have to initialise, it just cant take without initialisation
    }

    public Double[] checkTotalInCart(){
        clickHere(cartButton);
        cartItems = driver.findElements(itemCost);
        itemCostDouble = getAllCostInDouble(cartItems, dataPriceAttribute);
        for(double i:itemCostDouble){
            sum+=i;
        }
        totalCost = driver.findElement(totalCostElement).getText().substring(1).replaceAll(",", "");

        return new Double[]{Double.valueOf(totalCost), sum};

        /*if(Double.valueOf(totalCost)==sum){
            return true;
        }else {
            System.out.println("The total showed in Amazon is: "+ totalCost);
            System.out.println("The total of Individual product is: "+sum);
            return false;
        }*/
    }

}
