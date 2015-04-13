package WellsFargoPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Config.OR;

public class A3_getQuoteStep1 {
	
	@FindBy(xpath=OR.selectQuote)
	public WebElement selectQuote;
	@FindBy(xpath=OR.zipCode)
	public WebElement zipCode;
	@FindBy(xpath=OR.radioNo)
	public WebElement radioNo;
	@FindBy(xpath=OR.radioYes)
	public WebElement radioYes;
	@FindBy(xpath=OR.continueBtn)
	public WebElement continueBtn;
	
	
	public void selectInsuranceType(String typeInsurance) {
		
		Select quote = new Select(selectQuote);
		quote.selectByVisibleText(typeInsurance);
	}
	
	public void enterZip(String zipcode) {
		
		zipCode.sendKeys(zipcode);
	}
	
	public void selectRadioNo() {
		
		radioNo.click();
	}
	
	public void selectRadioYes() {
		
		radioYes.click();
	}
	
	public void clickContinue() {
		
		continueBtn.click();
		
	}
	
	

}
