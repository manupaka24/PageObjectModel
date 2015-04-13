package WellsFargoPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.OR;

public class A1_WellsHomePage {
	
	public WebDriver Net;
	
	@FindBy(xpath = OR.Insurance)
	public WebElement Insurance;
	@FindBy(xpath = OR.getQuotes)
	public WebElement getQuotes;
	@FindBy(xpath=OR.MortgageRate)
	public WebElement MortgageRate;
	@FindBy(xpath=OR.Banking)
	public WebElement Banking;
	
	public void getLinks() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Platinum24\\Desktop\\Selenium Java\\chromedriver.exe");
		Net = new ChromeDriver();
		
		Net.get("http://www.wellsfargo.com/");
	
	}
	
	public A2_clickGetQuotesBtns clickInsuranceQuotesLink() {
		
		Insurance.click();
		getQuotes.click();
		return PageFactory.initElements(Net, A2_clickGetQuotesBtns.class);
	}	
	
	
	public A5_MortgageRateMain clickMortgageRate() {
		
		Banking.click();
		MortgageRate.click();	
		return PageFactory.initElements(Net, A5_MortgageRateMain.class);	
	}
}










