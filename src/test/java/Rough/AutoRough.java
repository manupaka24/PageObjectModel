package Rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import AutoPages.A1_HomePageAT;
import AutoPages.A2_SearchPage;
import UtilsReuse.ImageUtil;
import UtilsReuse.ReuseUtil;

public class AutoRough {

	public WebDriver Net;

	public void getImages() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		
		Net.get("http://www.nba.com/");
		
		WebElement nba = Net.findElement(By.xpath("//*[@id='searchform-col-wrapper-col1-listingsSearch-bodystyle-j_id_1_g3-vehicleStyleCodes']"));
		
		ImageUtil img = new ImageUtil();
		img.getElementImage(Net, nba, "NBA");
	}
	
	//@Test
	public void getAutoImg() throws IOException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		
		Net.get("http://www.autotrader.com/");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Net.manage().window().maximize();
		Net.findElement(By.xpath("//*[@id='j_id_1_dw-j_id_1_dx_1']/div/div[1]/div/div[2]/a")).click();
		Thread.sleep(10000);
		WebElement autoImg = Net.findElement(By.xpath("//*[@id='searchform-col-wrapper-col1-listingsSearch-bodystyle-j_id_1_g3-vehicleStyleCodes']/li[6]/label"));
	//	((JavascriptExecutor) Net).executeScript("arguments[0].scrollIntoView(true);", autoImg);
		
		JavascriptExecutor jse = (JavascriptExecutor)Net;
		jse.executeScript("scroll(0, 650);");
		
		Thread.sleep(10000);
		ReuseUtil imgs = new ReuseUtil();
		imgs.getScreenShot(Net, "EntirePage");
		ImageUtil img = new ImageUtil();
	
		img.getElementImage(Net, autoImg, "AutoBody");
			
	}
	
	
	
}
