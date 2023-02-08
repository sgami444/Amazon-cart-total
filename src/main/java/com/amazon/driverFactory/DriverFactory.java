package com.amazon.driverFactory;
//  Load all the drivers here.
//  If changing driver, use another driver that is already defined in Configs

//  Set up a switch for different webdrivers, and return a WebDriver. the function takes in a string.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    static WebDriver driver;
    public static WebDriver getWebDriver(String browser){

        switch (browser){
            case "chrome":{
                WebDriverManager.chromedriver().setup();
                // We defined WebDriver driver before main as a static field, because we do not do that here.
                driver = new ChromeDriver();
                break;
            }
            case "edge":{
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            default:{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
}