package com.amazon.pages;

import com.amazon.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends TestBase {

    private By addToCartButton = By.cssSelector("input#add-to-cart-button");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        clickHere(addToCartButton);
    }
}
