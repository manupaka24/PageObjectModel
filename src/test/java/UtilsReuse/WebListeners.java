package UtilsReuse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebListeners extends AbstractWebDriverEventListener {


	public void afterClickOn(WebElement element, WebDriver Net) {
		
		System.out.println("Object Clicked");	
	}
	

	public void beforeNavigateTo(java.lang.String url,
	                      WebDriver driver) {
	//Called before get(String url) respectively navigate().to(String url).
		
		System.out.println("Before navigating to new page");
		
	}
	
	
	public void afterNavigateTo(java.lang.String url,
	                     WebDriver driver) {
		
		System.out.println("Navigating to a new page");

	}
	
	public void beforeNavigateBack(WebDriver driver) {
	
		System.out.println("Navigating back to previous page");
	//Called before navigate().back().

	}
	
	public void afterNavigateBack(WebDriver driver) {
	
	//Called after navigate().back(). Not called, if an exception is thrown.
	
	System.out.println("Navigated back to a new page");
	
	}
	
	public void beforeNavigateForward(WebDriver driver) {
//		Called before navigate().forward().
		
		System.out.println("Navigating to a new page");
	}
	
	public void afterNavigateForward(WebDriver driver) {
	//Called after navigate().forward(). Not called, if an exception is thrown.
	
	System.out.println("Navigated to new page successfully");
	
	}
	
	public void beforeFindBy(By by,
	                  WebElement element,
	                  WebDriver driver) {
	//Called before WebDriver.findElement(...), or WebDriver.findElements(...), or WebElement.findElement(...), or WebElement.findElements(...).
//	Parameters:element - will be null, if a find method of WebDriver is called.
	
		System.out.println("Processing to find the WebElement");
		
		
	}
	
	public void afterFindBy(By by,
	                 WebElement element,
	                 WebDriver driver) {
	//Called after WebDriver.findElement(...), or WebDriver.findElements(...), or WebElement.findElement(...), or WebElement.findElements(...).
	//Parameters:element - will be null, if a find method of WebDriver is called.
		System.out.println("WebElement found");
	
	}
	
	public void beforeClickOn(WebElement element,
	                   WebDriver driver) {
	//Called before WebElement.click().
		System.out.println("WebElent about to be clicked");
	}
	
	public void beforeChangeValueOf(WebElement element,
	                         WebDriver driver) {
	//Called before WebElement.clear(), WebElement.sendKeys(...).
		
		System.out.println("Changing webelement values");
	
	}
	
	public void afterChangeValueOf(WebElement element,
	                        WebDriver driver) {
	//Called after WebElement.clear(), WebElement.sendKeys(...)}. Not called, if an exception is thrown.

		System.out.println("WebElement values modified");
	}	
	
	public void beforeScript(java.lang.String script,
	                  WebDriver driver) {
	//Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[])
	
		System.out.println("Script getting ready to execute");
	}
	
	public void afterScript(java.lang.String script,
	                 WebDriver driver) {
	//Called after RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]). Not called if an exception is thrown
		
		System.out.println("Script finished execution, check reports");
		
	}
	
	public void onException(java.lang.Throwable throwable,
	                 WebDriver driver) {
	//Called whenever an exception would be thrown.
	
		System.out.println("An Exception is thrown");
	}
	
}
