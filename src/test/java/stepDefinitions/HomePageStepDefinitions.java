package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.HomePage;

public class HomePageStepDefinitions {

	public WebDriver driver;
	public HomePage home;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",".\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		home = new HomePage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);
	}

	@Then("Maximize window")
	public void maximize_window() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.manage().window().maximize();
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(title, driver.getTitle());   
	}

	@Then("Click on {string}")
	public void click_on(String text) {
		driver.findElement(By.xpath(" //a[text()=' Single user not found ']")).click();

	}
	
//	@Then("Click on {string}")
//	public void click_on(String text) {
//		driver.findElement(By.xpath("//span[text()='/api/users/23']")).getText();

	//}
	@Then("Close browser")
	public void close_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}
