package UtilsReuse;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class ImageUtil {
	
//	public WebDriver Net;
	
	public void getElementImage(WebDriver Net, WebElement element, String SaveAs) throws IOException {
	
	WebElement ele = element;   
	//Get entire page screenshot
	File screenshot = ((TakesScreenshot)Net).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);
	//Get the location of element on the page
	Point point = ele.getLocation();
	//Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();
	int xPoint = point.getX();
	int yPoint = point.getY();
	
	Rectangle rect = new Rectangle(eleWidth, eleHeight);
	
	
	System.out.println("Element xPoint: " + xPoint);
	System.out.println("Element yPoint: " + yPoint);
	System.out.println("Element width: " + eleWidth);
	System.out.println("Element height: " + eleHeight);
	
	//Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(xPoint, yPoint, rect.width, rect.height);
	ImageIO.write(eleScreenshot, "png", screenshot);
	//Copy the element screenshot to disk
	FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\"+SaveAs+".jpeg"));
	
}
	
	public String compareImages(String img1,String img2) { 

        System.out.println("Comparing Images......");
        boolean ret = true;
        String strMsg = null;
        try {
        Raster ras1 = ImageIO.read(new File(img1)).getData();
        Raster ras2 = ImageIO.read(new File(img2)).getData();
        
      //Comparing the the two images for number of bands,width & height.
        
         if (ras1.getNumBands() != ras2.getNumBands()
           || ras1.getWidth() != ras2.getWidth()
           || ras1.getHeight() != ras2.getHeight()) {
            ret=false;
         }else{
         // Once the band ,width & height matches, comparing the images.
        	 
         search: for (int i = 0; i < ras1.getNumBands(); ++i) {
          for (int x = 0; x < ras1.getWidth(); ++x) {
           for (int y = 0; y < ras1.getHeight(); ++y) {
            if (ras1.getSample(x, y, i) != ras2.getSample(x, y, i)) {
           // If one of the result is false setting the result as false and breaking the loop.
             ret = false;
             break search;
            }
           }
          }
         }
         }
         if (ret == true) {
             strMsg = "Images are matched";
         } else {
             strMsg="Images are not matched";
         }
        } catch (IOException e) {
         System.out.println(e);
        }
        System.out.println(strMsg);
        return strMsg;
       }
	
	   public void getWebElementCoordinates(WebDriver Net, WebElement element, String SaveAs) throws IOException  {

	        File screen = ((TakesScreenshot)Net).getScreenshotAs(OutputType.FILE);
	        Point p = element.getLocation();

	        int width = element.getSize().getWidth();
	        int height = element.getSize().getHeight();

	        BufferedImage img = ImageIO.read(screen);
	        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,   
	                                 height);
	        ImageIO.write(dest, "png", screen);
	        
	        
	        File f = new File(System.getProperty("user.dir")+"\\Screenshots\\"+SaveAs+".jpeg");
	        FileUtils.copyFile(screen, f);
	        
	    }
}
