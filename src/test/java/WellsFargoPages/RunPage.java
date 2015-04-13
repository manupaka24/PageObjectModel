package WellsFargoPages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.testng.AllureTestListener;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import Config.OR;
import UtilsExcel.XLReader;

public class RunPage {
	
	public WebDriver Net;
	
	@Parameter ("Author")
	public String Romeo;
	@Parameter ("Character Name")
	public String Ranaldo;
	@Parameter ("Great Britain")
	public String GreatWorks;
	
	@BeforeTest
	public void getBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Platinum24\\Desktop\\Selenium Java\\chromedriver.exe");
		Net = new ChromeDriver();
		Net.get("http://www.wellsfargo.com/");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Features("Wells Fargo Feature")
	@Stories({"Get Quotes"})
	@Test
	public void RunTest() throws IOException {

		
		Romeo = "Romeo and Juliet";
		Ranaldo="Character";
		GreatWorks="British";
		System.out.println(Romeo+" "+Ranaldo+" "+GreatWorks);
		
		A1_WellsHomePage page = PageFactory.initElements(Net, A1_WellsHomePage.class);
		A2_clickGetQuotesBtns btnClick = PageFactory.initElements(Net, A2_clickGetQuotesBtns.class);
		A3_getQuoteStep1 step1 = PageFactory.initElements(Net, A3_getQuoteStep1.class);
		A4_getQuoteStep2 step2 = PageFactory.initElements(Net, A4_getQuoteStep2.class);
		
		AShot shot = new AShot();
		WebElement img = Net.findElement(By.xpath("//*[@id='shell']/nav"));
		captureScreenshot(Net);
		captureAShot(Net, shot, img); 
		page.clickInsuranceQuotesLink();
		btnClick.getAutoQuote();
		step1.selectInsuranceType("Auto Insurance");
		step1.enterZip("11001");
		step1.selectRadioNo();
		captureScreenshot(Net);
		step1.clickContinue();
		step2.enterInfo();
		captureScreenshot(Net);
		stepAct();
		
	}
	
	
	@Step
    public void stepAct() {
		
		System.out.println("Hosptials");	
    }
	
	
	public void tableBox() {
		
		A1_WellsHomePage page = PageFactory.initElements(Net, A1_WellsHomePage.class);
		A5_MortgageRateMain main = PageFactory.initElements(Net, A5_MortgageRateMain.class);
		page.clickMortgageRate();
		main.tableBox();	
	}
	
	
	@Attachment(value="Screenshot", type="image/png")
	private static byte[] captureScreenshot(WebDriver Net) {
	
	    byte[] screenshot = null;
	    {
	            screenshot = ((TakesScreenshot)Net).getScreenshotAs(OutputType.BYTES);
	        }
	  return screenshot;
	}
	
	@Attachment(value="Screenshot", type="image/png")
	private static byte[] captureAShot(WebDriver Net, AShot shot, WebElement el) throws IOException {
	
		BufferedImage img = shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Net, el).getImage();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", baos);
		byte[] bytes = baos.toByteArray();
	  
	  return bytes;
	}
}
