package runPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.OR;
import UtilsExcel.XLReader;
import WellsFargoPages.A1_WellsHomePage;
import WellsFargoPages.A2_clickGetQuotesBtns;
import WellsFargoPages.A3_getQuoteStep1;
import WellsFargoPages.A4_getQuoteStep2;

public class RunPage {

	public static WebDriver Net;
	
	
	@BeforeTest
	public void getBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Platinum24\\Desktop\\Selenium Java\\chromedriver.exe");
		Net = new ChromeDriver();
		Net.get("http://www.wellsfargo.com/");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void RunTest() {
		
		A1_WellsHomePage page = PageFactory.initElements(Net, A1_WellsHomePage.class);
		A2_clickGetQuotesBtns btnClick = PageFactory.initElements(Net, A2_clickGetQuotesBtns.class);
		A3_getQuoteStep1 step1 = PageFactory.initElements(Net, A3_getQuoteStep1.class);
		A4_getQuoteStep2 step2 = PageFactory.initElements(Net, A4_getQuoteStep2.class);
		
		page.clickInsuranceQuotesLink();
		btnClick.getAutoQuote();
		step1.selectInsuranceType("Auto Insurance");
		step1.enterZip("11001");
		step1.selectRadioNo();
		step1.clickContinue();
		step2.enterInfo();
	}
	
	@Test
	public void tableBox() {
		
		A1_WellsHomePage page = PageFactory.initElements(Net, A1_WellsHomePage.class);
		page.clickMortgageRate();
		String[][] dArray = new String[10][10];
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
