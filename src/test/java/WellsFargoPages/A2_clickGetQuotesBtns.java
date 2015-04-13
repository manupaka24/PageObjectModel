package WellsFargoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Config.OR;

public class A2_clickGetQuotesBtns extends A1_WellsHomePage {

	public WebDriver Net;
	
	@FindBy(xpath=OR.getAutoQuote)
	public WebElement getAutoQuote;
	@FindBy(xpath=OR.getRentQuote)
	public WebElement getRentQuote;
	@FindBy(xpath=OR.getHomeQuote)
	public WebElement getHomeQuote;
	@FindBy(xpath=OR.getLifeQuote)
	public WebElement getLifeQuote;
	

	
	public A3_getQuoteStep1 getAutoQuote() {
		
		getAutoQuote.click();
		return PageFactory.initElements(Net, A3_getQuoteStep1.class);	
	}
	
	public A3_getQuoteStep1 getHomeQuote() {
		
		getHomeQuote.click();
		return PageFactory.initElements(Net, A3_getQuoteStep1.class);
	}
	
	public void getRentQuote() {
		
		getRentQuote.click();	
	}

	public void getLifeQuote() {
	
		getLifeQuote.click();	
	}
	
	
	
}
