package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupportPage {
	

	public SupportPage(WebDriver driver) {	
		

	}

	public static void main(String[]args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver",".\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://reqres.in");
		driver.findElement(By.xpath("//a[@href='#support-heading']"));
		Thread.sleep(8000);
		
		String actualRequest = "One-time payment ($)";
		String actualResponse = "Monthly support ($5/month)";
		
		String oneTime = driver.findElement(By.xpath("//label[text()='One-time payment ($)']")).getText();
		String monthlySupport = driver.findElement(By.xpath("//label[text()='Monthly support ($5/month)']")).getText();
		
		Assert.assertEquals(actualRequest, oneTime);
		Assert.assertEquals(actualResponse, monthlySupport);
		
		
		try 
		{
		     if(driver.findElement(By.id("trigger-pro")).isDisplayed()) 
		     {
		          driver.findElement(By.id("trigger-pro")).getText();
		     }
		}
		catch (Exception e)
		{
		    System.out.println("Upgrade button is not there");
		}
	} 	
		
	}


