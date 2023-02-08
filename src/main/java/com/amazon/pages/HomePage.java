package com.amazon.pages;

//  Since TestBase contains most of the methods, Extend that class to other page classes

import com.amazon.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends TestBase {
    private By searchBox = By.cssSelector("input[type='text'][name='field-keywords']");
    private By firstSearchItem = By.cssSelector("div[data-index='2'] h2 a");

    public HomePage(WebDriver driver){
        this.driver = driver;   // Every subclass we have to initialise, it just cant take without initialisation
    }
    public void searchForItem(String item){
        clearSendKeysAndSearch(item, searchBox);
        clickHere(firstSearchItem);
    }
}
