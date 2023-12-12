package com.firstcry.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoggedInPage {

WebDriver driver;
	
	@FindBy(xpath = "//span[@class='anch myacc_2']")
	public WebElement myAccount;
	
	@FindBy(xpath = "(//a[text()='My Profile'])[1]")
	public WebElement myProfile;
	
	@FindBy(xpath = "//*[@id='profile1']/div/div[3]/div[1]/div/span")
	public WebElement profileEmail;

	public LoggedInPage(WebDriver driver) {
	    super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void goToProfile() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(myAccount);
		Thread.sleep(2000);
		action.moveToElement(myProfile);
		action.click().build().perform();
	}
	
	public String getProfileEmail() {
		return profileEmail.getText();
	}
	
}
