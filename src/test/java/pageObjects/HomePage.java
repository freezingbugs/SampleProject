package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage {
		
 public WebDriver ldriver;


public HomePage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
	ldriver= rdriver;
	}

@Test
public void runTests(){
	
	System.setProperty("webdriver.chrome.driver",".\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://reqres.in");
	driver.findElement(By.xpath(" //a[text()=' Single user not found ']")).click();
	
	String actualRequest = "/api/users/23";
	String actualResponse = "404";
	
	String request = driver.findElement(By.xpath("//span[text()='/api/users/23']")).getText();
	String response = driver.findElement(By.xpath("//span[@class='response-code bad']")).getText();
	
	Assert.assertEquals(actualRequest, request);
	Assert.assertEquals(actualResponse, response);
	
	
	try 
	{
	     if(driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed()) 
	     {
	          driver.findElement(By.xpath("//button[text()='Support ReqRes']")).getText();
	     }
	}
	catch (Exception e)
	{
	    System.out.println("Support Reqres button is not there");
	}
} 	
	

}
