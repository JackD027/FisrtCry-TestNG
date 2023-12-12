package com.firstcry.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    public static WebDriver driver;

    private String baseURL;

    public Base() {
    }

    public void LoadProperties() throws IOException {
        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
        Properties props = new Properties();
        props.load(reader);
        baseURL = props.getProperty("baseURL");
    }

    @BeforeTest
    public void OpenBrowser() throws IOException {
    	LoadProperties(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterTest
    public void CloseBrowser() {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
