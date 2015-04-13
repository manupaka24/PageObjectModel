package AutoPages;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.testng.AllureTestListener;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class runAuto {

	public WebDriver Net;
	@Parameter ("Author")
	public String Romeo;
	@Parameter ("Character Name")
	public String Ranaldo;
	@Parameter ("Great Britain")
	public String GreatWorks;
	
	public void runTest() throws IOException {
		Romeo= "Shakesspeare";
		Ranaldo="Character";
		GreatWorks="British";
		System.out.println(Romeo+Ranaldo+GreatWorks);
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		Net.get("http://www.autotrader.com/");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		A1_HomePageAT page = PageFactory.initElements(Net, A1_HomePageAT.class);
		A2_SearchPage sPage = PageFactory.initElements(Net, A2_SearchPage.class);
		page.clickAdvanceSearchBtn();
		sPage.enterValues("100 Miles", "55303", "$15,000", "2014", "2016");
		
		//WebElement newEl = Net.findElement(By.xpath("//*[@id='j_id_37g_6']/h2/a/span[1]/span"));
		//Assert.assertTrue(newEl.getText().contains("New"));
	}
	
	@Features("aShot Feature")
	@Stories({"Nasa.gov"})
	//@Test
	public void getAShot() throws IOException, AWTException {
		Romeo= "Shakesspeare";
		Ranaldo="Character";
		GreatWorks="British";
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		Net.get("http://www.nasa.gov/");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement img = Net.findElement(By.xpath("//*[@id='image_of_the_day_1_imageofday']/div[1]/a/img"));
		
		AShot shot = new AShot();
		shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Net, img);
		text();
		writeText();
	}
	
	@Attachment(value="Witten", type = "image/png")
	public String text() {
		
		return "String theory";
	}
	
	@Step("Wonders")
	public void writeText() {
		
		System.out.println("Barley there");
	}

}
