package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupportPage {
	
	public WebDriver ldriver;

	public SupportPage(WebDriver rdriver) {
			// TODO Auto-generated constructor stub
		ldriver= rdriver;
		}

//	@Test
//	public void verifySupport() throws Exception {
//
//		System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://reqres.in");
//		driver.findElement(By.xpath("//a[@href='#support-heading']")).click();
//		Thread.sleep(8000);
//
//		boolean actualOneTime = driver.findElement(By.xpath("//label[text()='One-time payment ($)']")).isDisplayed();
//		boolean actualmonthly = driver.findElement(By.xpath("//label[text()='Monthly support ($5/month)']"))
//				.isDisplayed();
//
//		Assert.assertEquals(actualOneTime, true);
//		Assert.assertEquals(actualmonthly, true);
//
//		boolean upgrade = driver.findElement(By.id("trigger-pro")).isDisplayed();
//		try {
//			if (upgrade == true) {
//				System.out.println("Upgrade button is present");
//			} else {
//				System.out.println("Upgrade button is not present");
//			}
//		} catch (Exception e) {
//
//		}
//	}

}
