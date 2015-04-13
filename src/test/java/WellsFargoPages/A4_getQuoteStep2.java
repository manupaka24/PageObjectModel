package WellsFargoPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Config.OR;

public class A4_getQuoteStep2 {
	
	@FindBy(xpath=OR.firstName)
	public WebElement firstName;
	@FindBy(xpath=OR.lastName)
	public WebElement lastName;
	@FindBy(xpath=OR.Address)
	public WebElement Address;
	@FindBy(xpath=OR.city)
	public WebElement city;
	@FindBy(xpath=OR.zip)
	public WebElement zip;
	
	
	public void enterInfo() {
		
		firstName.sendKeys("Vin");
		lastName.sendKeys("Sane");
		Address.sendKeys("18 stewart avenue");
		city.sendKeys("Garden City");
		zip.sendKeys("11632");
		
		
	}
	
	
}