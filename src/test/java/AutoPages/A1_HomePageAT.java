package AutoPages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import UtilsExcel.XLCreateSheet;
import UtilsExcel.XLReader;
import UtilsExcel.XLWriter;
import Config.OR;

public class A1_HomePageAT {
	private WebDriver Net;
	
	
	public A1_HomePageAT(WebDriver Net) {	
		this.Net = Net;
	}
	
	@FindBy(xpath = OR.carMake)
	public WebElement carMake;
	@FindBy(xpath = OR.carModel)
	public WebElement carModel;
	@FindBy(xpath = OR.price)
	public WebElement price;
	@FindBy(xpath = OR.zipCode)
	public WebElement zipCode;
	@FindBy(xpath=OR.advanceSearch)
	public WebElement advanceSearch;
	
	public void getCarMake() {	
		carMake.click();
	}
	
	public void WriteCarMaketoExcel() throws IOException {
		XLReader xl = new XLReader(System.getProperty("user.dir") + "\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx");	
		String[] autoData = {"Expected Model"};
		Select cMake = new Select(carMake);
		List<WebElement> Make = cMake.getOptions();
		for (int i=1; i<Make.size(); i++) {
			cMake.selectByIndex(i);
			String sMake = cMake.getFirstSelectedOption().getText();	
			XLCreateSheet cs = new XLCreateSheet();
			cs.createSheet(System.getProperty("user.dir") + "\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx", sMake);
			cs.createRow(System.getProperty("user.dir") + "\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx", sMake, 0);
			System.out.println("Adding " + sMake + " sheet to the excel workbook");
			for (int a=0; a<autoData.length; a++) {
			cs.setColumnData(System.getProperty("user.dir") + "\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx", sMake, 0, a, autoData[a]);
			System.out.println("Adding " + autoData[0] + " column to the " + sMake + " sheet");
			}
			System.out.println("Finished adding " + sMake + " sheet to excel");
		}
		System.out.println("Sucessfully created all the car-model specific excel sheets to the workbook and initiated columns");
	}
	
	public void writeCarModeltoExcel() throws IOException, InterruptedException {
		XLCreateSheet cs = new XLCreateSheet();
		Select cMake = new Select(carMake);
		List<WebElement> Make = cMake.getOptions();
		for (int i=19; i<Make.size(); i++) {
			cMake.selectByIndex(i);
			String sMake = cMake.getFirstSelectedOption().getText().toString();
			System.out.println("Selected car-make: " + sMake);	
			Thread.sleep(2000);
			Select cModel = new Select(carModel);
			List<WebElement> Model = cModel.getOptions();
			for(int b=1; b<Model.size(); b++) {	
				cModel.selectByIndex(b);
				String sModel = cModel.getFirstSelectedOption().getText().toString();
				System.out.println("Selected car-model: " + sModel);
				cs.writeDataToExcel(System.getProperty("user.dir")+"\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx", sMake, b, 5, sModel);
				//cs.createRow(System.getProperty("user.dir") + "\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx", sMake, b);	
				//xlw.writeDataToExcel(System.getProperty("user.dir")+"\\Framework_POM\\ExcelFiles\\POM_Excel.xlsx", sMake, b, 0, sModel);
			}
		}
	}
	
	public boolean find(WebElement els, Select sel, List<WebElement> element) {
		boolean result = false;
		int attempts = 0;
		while(attempts<6) {
		try {
			sel = new Select(els);
			element = sel.getOptions();
			result = true;
			break;
		}
		catch(StaleElementReferenceException e) {
		}
		attempts++;
		}
		return result;
	}
	
	public boolean retryingFindClick(String xpath) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 6) {
            try {
              Net.findElement(By.xpath(xpath));
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
	}
	
	public void getCarModel() {
		carModel.click();
	}

	public void getPrice() {
		price.click();
	}
	
	public void zipCode() {
		zipCode.click();
	}
	
	public A2_SearchPage clickAdvanceSearchBtn() {	
		advanceSearch.click();	
		return PageFactory.initElements(Net, A2_SearchPage.class);
	}
}
