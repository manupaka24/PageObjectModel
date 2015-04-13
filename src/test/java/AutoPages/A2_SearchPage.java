package AutoPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilsExcel.XLCreateSheet;
import UtilsExcel.XLDataProvider;
import UtilsExcel.XLReader;
import UtilsReuse.ImageUtil;
import Config.OR;

public class A2_SearchPage {
	
	public WebDriver Net;
	
	@FindBy(xpath=OR.radiusRange)
	public WebElement radiusRange;
	@FindBy(xpath=OR.zippCode)
	public WebElement zippCode;
	@FindBy(xpath=OR.newCheckBox)
	public WebElement newCheckBox;
	@FindBy(xpath=OR.usedCheckBox)
	public WebElement usedCheckBox;
	@FindBy(xpath=OR.certifiedCheckBox)
	public WebElement certifiedCheckBox;
	@FindBy(xpath=OR.minPrice)
	public WebElement minPrice;
	@FindBy(xpath=OR.maxPrice)
	public WebElement maxPrice;
	@FindBy(xpath=OR.allStyles)
	public WebElement allStyles;
	@FindBy(xpath=OR.fromYear)
	public WebElement fromYear;
	@FindBy(xpath=OR.toYear)
	public WebElement toYear;
	@FindBy(xpath=OR.carSearch)
	public WebElement carSearch;
	@FindBy(xpath=OR.adImage)
	public WebElement adImage;
	
	
	public A2_SearchPage(WebDriver Net) {
		
		this.Net = Net;
	}
	
	
	//@Test(dataProvider="autoSearchData")
	public void enterValues(String distance, String zip, String maximPrice, String mYear, String maYear) throws IOException {
		
		String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\ExcelFiles\\TestData.xlsx";
		
		XLCreateSheet xlc = new XLCreateSheet();
		XLReader xlr = new XLReader(filepath);
		
		Select radius = new Select(radiusRange);
		radius.selectByVisibleText(distance);	
		zippCode.clear();
		zippCode.sendKeys(zip);	
		newCheckBox.click();
		for (int i=1; i<xlc.getTotalRows(filepath, 1); i++) {
		if (xlr.getCellData("AutoAdvanceSearch", 2, i).equals("New")) {
			newCheckBox.click();
		}
		else if (xlr.getCellData("AutoAdvanceSearch", 2, i).equals("Used")) {
			usedCheckBox.click();
		}
		else if (xlr.getCellData("AutoAdvanceSearch", 2, i).equals("Certified")) {	
			certifiedCheckBox.click();
			}
		else {
			continue;
		}
		}
		Select maximumPrice = new Select(maxPrice);
		maximumPrice.selectByVisibleText(maximPrice);
		allStyles.click();
		Select minYear = new Select(fromYear);
		minYear.selectByVisibleText(mYear);
		Select maxYear = new Select(toYear);
		maxYear.selectByVisibleText(maYear);
		carSearch.click();
	}
	
	//@DataProvider(name="autoSearchData")
	public Object[][] fillData() throws IOException {	
		XLDataProvider xl = new XLDataProvider();
		Object[][] auto = xl.Data(System.getProperty("user.dir") + "src\\test\\java\\ExcelFiles\\TestData.xlsx", "AutoAdvanceSearch");
		return auto;
	}
	
	public void getElementStats() throws IOException {
		
	//	System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
	//	Net = new ChromeDriver();
		for(int i=1; i<=12; i++) {
		String styleBody = OR.modelStyle + i + OR.modelStyelNum;
		WebElement style = Net.findElement(By.xpath(styleBody));
		Dimension styleSize = style.getSize();
		System.out.println("Size of the webelement on page: " + styleSize);
		Point local = style.getLocation();
		System.out.println("Location of webelement on page: " + local);
		ImageUtil img = new ImageUtil();
		img.getElementImage(Net, style, i+". " + "StyleBody");
		
		
		}	
	}
	
	
	
	
	
}
