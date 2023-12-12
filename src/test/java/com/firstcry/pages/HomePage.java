package com.firstcry.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.firstcry.base.Base;

public class HomePage extends Base {

	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='anch poplogin_main poplogin R12_61']")
	public WebElement loginElement;

	public HomePage(WebDriver driver) {
	    super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}


	@Test
    public void openHome() {
        driver = getDriver();
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }
    
    @Test
    public void clickOnLogin() {
    	loginElement.click();
    }
}
