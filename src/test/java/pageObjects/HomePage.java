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
		ldriver = rdriver;
	}

//	@Test
//	public void runTests() throws Exception {
//
//		System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		//driver.get("https://reqres.in");
//		driver.findElement(By.xpath(" //a[text()=' Single user not found ']")).click();
//
//		String ExpectedRequest = "/api/users/23";
//		String ExpectedResponse = "404";
//
//		String ActualRequest = driver.findElement(By.xpath("//span[text()='/api/users/23']")).getText();
//		Thread.sleep(7000);
//		String ActualResponse = driver.findElement(By.xpath("//span[@class='response-code bad']")).getText();
//
//		Assert.assertEquals(ActualRequest, ExpectedRequest);
//		Assert.assertEquals(ActualResponse, ExpectedResponse);
//		System.out.println("Actual Request " + ActualRequest);
//		System.out.println("Actual Response " + ActualResponse);
//
//		try {
//			Boolean e = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
//			Assert.assertEquals(e, true);			
//			if (e == true) {
//				System.out.println("Support button is displayed");
//			}
//			else {
//				System.out.println("Support Reqres button is not there");
//			}
//		} catch (Exception e) {			
//		}
//	}

}
