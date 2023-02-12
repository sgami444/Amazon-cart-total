package com.amazon;

import com.amazon.config.Configs;
import com.amazon.driverFactory.DriverFactory;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestBase {
    protected WebDriver driver;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.getWebDriver(Configs.CHROME_BROWSER);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Configs.MED_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Configs.MED_WAIT));

        driver.navigate().to(Configs.URL);
        createObjectOfPages();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    public void clearSendKeysAndSearch(String item, By by){
        explicitWait(ExpectedConditions.visibilityOf(driver.findElement(by)));
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(item, Keys.ENTER);
    }
    public void clickHere(By by){
        explicitWait(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    public void explicitWait(ExpectedCondition<WebElement> condition){
        new WebDriverWait(driver, Duration.ofSeconds(Configs.LONG_WAIT)).until(condition);
    }
    public List<Double> getAllCostInDouble (List<WebElement> webElements, String attributeName){
        List<Double> res = new ArrayList<>();
        webElements.forEach(element -> {
            res.add(Double.valueOf(element.getAttribute(attributeName).replaceAll(",","")));
        });
        return res;
    }
    public void createObjectOfPages(){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }
}
