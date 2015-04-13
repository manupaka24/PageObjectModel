package WellsFargoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
	




import org.openqa.selenium.support.PageFactory;

import UtilsExcel.XLReader;
import Config.OR;
	
public class A5_MortgageRateMain {
	
	public WebDriver Net;
	
	@FindBy(xpath=OR.PurchaseRate)
	public WebElement PurchaseRateTab;
	@FindBy(xpath=OR.Box)
	public WebElement Box;
	@FindBy(xpath=OR.tData)
	public WebElement tData;
	@FindBy(xpath=OR.trNum)
	public WebElement trNum;
	@FindBy(xpath=OR.tcNum)
	public WebElement tcNum;
	
	public A5_MortgageRateMain(WebDriver Net) {
		this.Net = Net;
	}

	public void clickPurchaseRateTabl() {
		
		PurchaseRateTab.click();	
	}
	
	public void tableBox() {
		
		for (int i=2; i<=13; i++) {	
			for (int j=1; j<=2; j++) {	
				if (i==7 | i==11) {
					continue;
				}	
				String table = OR.tData + i + OR.trNum + j + OR.tcNum;
				String tOutput = Net.findElement(By.xpath(table)).getText().toString();	
				System.out.println(tOutput);	
				XLReader read = new XLReader("C:\\Users\\Platinum24\\Desktop\\EEworkSpace\\AllureMavens\\src\\test\\java\\ExcelFiles\\TestData.xlsx");
				String xRead = read.getCellData("WellsFargoMortgageRates", j, i-1).toString();
				if (xRead.equals(tOutput)) {		
					System.out.println("Table data successfully match");
				}
				else {		
					System.out.println("Table data does not match with expected data");
				}	
			}
		}
	}
	
}
