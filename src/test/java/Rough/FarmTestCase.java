package Rough;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
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
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class FarmTestCase {

	public WebDriver Net;
	@Parameter("Author")
	String shakesspeare;
	@Parameter("Character")
	String Romeo;
	@Parameter("Animal")
	String Zebra;	
	@Parameter("Author")
	String Darwin;
	@Parameter("Character")
	String Birds;
	@Parameter("Animal")
	String Hawks;	
	@Parameter("Author")
	String Marine;
	@Parameter("Character")
	String Aquatic;
	@Parameter("Animal")
	String Whale;
	
	@Features("Basketball")
	@Stories("Legends")
//	@Test
	public void visit() throws IOException {
		
		shakesspeare= "Shakesspeare: English literature scriptwriter/novelist/poet";
		Romeo = "Romeo: Male protagonist in 'Romeo and Juliet' play";
		Zebra = "Zebra: Striated animal observed in open grass landscapes";
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		
		Net.get("http://www.nba.com/");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement img = Net.findElement(By.xpath("//*[@id='nbaHeader']/span/a"));
		AShot shot = new AShot();
		shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Net, img).getImage();
		captureScreenshot(Net);
		captureAShot(Net, shot, img);
		System.out.println(shakesspeare);
		System.out.println(Romeo);
		System.out.println(Zebra);
	}
	
	/*
	
	@Features("Wild Life")
	@Stories("Carnivores")
	@Test
	public void visitOne() throws IOException {
		
		Darwin= "Darwin: English evolutionist, author of 'Origin Of Species'";
		Birds = "Birds: Living organism with ability to fly.";
		Hawks = "Hawks: Belongs to the category of bird characterized by enlarged/sharp beaks";
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		
		Net.get("https://www.google.com/search?q=evolution+pictures&es_sm=93&biw=1304&bih=683&tbm=isch&imgil=M3dM_SXxhVjeIM%253A%253BOSKnzk5VEqbDHM%253Bhttp%25253A%25252F%25252Fwww.lifewithalacrity.com%25252F2004%25252F10%25252Ftracing_the_evo.html&source=iu&pf=m&fir=M3dM_SXxhVjeIM%253A%252COSKnzk5VEqbDHM%252C_&usg=__7stDLjqxRRuOZreVd4RclafQIiU%3D&ved=0CDEQyjc&ei=uu4qVYWrL4jzggSg64L4Cg#imgrc=_");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement img = Net.findElement(By.xpath("//*[@id='ifb']/a[2]/div/div[1]/div[1]/div/img"));
		AShot shot = new AShot();
		shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Net, img).getImage();
		captureScreenshot(Net);
		captureAShot(Net, shot, img);
		System.out.println(Darwin);
		System.out.println(Birds);
		System.out.println(Hawks);
	}
	
	
	@Features("Sea Life")
	@Stories("Carnivores")
	@Test
	public void visitTwo() throws IOException {
		
		Marine= "Marine: belonging to water environments";
		Aquatic = "Aquatic: water-living";
		Whale = "Whale: An extremely large marine organism";
		System.setProperty("webdriver.chrome.driver", "C://users//platinum24//desktop//selenium java//chromedriver.exe");
		Net = new ChromeDriver();
		
		Net.get("https://www.google.com/search?q=whales&espv=2&biw=1304&bih=683&tbm=isch&tbo=u&source=univ&sa=X&ei=7e4qVc60EIWoNv_FgBg&ved=0CJcBEIke");
		Net.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement img = Net.findElement(By.xpath("//*[@id='abar_button_opt']"));
		AShot shot = new AShot();
		shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Net, img).getImage();
		captureScreenshot(Net);
		captureAShot(Net, shot, img);
		System.out.println(Marine);
		System.out.println(Aquatic);
		System.out.println(Whale);
		
	}
	
	*/
	
	
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
