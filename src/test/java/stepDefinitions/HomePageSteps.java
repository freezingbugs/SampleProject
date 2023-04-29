package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.SupportPage;

public class HomePageSteps extends BaseClass {

	@Given("Click on SINGLE USER NOT FOUND")
	public void click_on_single_user_not_found() {
		driver.findElement(By.xpath(" //a[text()=' Single user not found ']")).click();
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		home = new HomePage(driver);
		// support = new SupportPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@Then("Maximize window")
	public void maximize_window() {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().window().maximize();
	}

	@Then("Close Browser")
	public void close_browser() {
		driver.quit();
	}

	@Then("Verify Request")
	public void verify_request() {
		String ExpectedRequest = "/api/users/23";
		String ActualRequest = driver.findElement(By.xpath("//span[text()='/api/users/23']")).getText();
		Assert.assertEquals(ActualRequest, ExpectedRequest);
		System.out.println("Actual Request " + ActualRequest);
	}

	@Then("Verify Response")
	public void verify_response() throws Exception {
		String ExpectedResponse = "404";
		Thread.sleep(7000);
		String ActualResponse = driver.findElement(By.xpath("//span[@class='response-code bad']")).getText();
		Assert.assertEquals(ActualResponse, ExpectedResponse);
		System.out.println("Actual Response " + ActualResponse);
	}

	@Then("Validate support button is displayed")
	public void validate_support_button_is_displayed() {
		try {
			Boolean e = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
			Assert.assertEquals(e, true);
			if (e == true) {
				System.out.println("Support button is displayed");
			} else {
				System.out.println("Support Reqres button is not there");
			}
		} catch (Exception e) {
		}
	}

	@When("Click on Support Reqres button")
	public void click_on_support_reqres_button() throws Exception {

		driver.findElement(By.xpath("//a[@href='#support-heading']")).click();
		Thread.sleep(8000);
	}

	@When("Verify one-time & monthly support options are present")
	public void verify_one_time_monthly_support_options_are_present() {
		// Write code here that turns the phrase above into concrete actions
		boolean actualOneTime = driver.findElement(By.xpath("//label[text()='One-time payment ($)']")).isDisplayed();
		boolean actualmonthly = driver.findElement(By.xpath("//label[text()='Monthly support ($5/month)']"))
				.isDisplayed();

		Assert.assertEquals(actualOneTime, true);
		Assert.assertEquals(actualmonthly, true);
	}

	@When("Verify upgrade button is present")
	public void verify_upgrade_button_is_present() {
		// Write code here that turns the phrase above into concrete actions
		boolean upgrade = driver.findElement(By.id("trigger-pro")).isDisplayed();
		try {
			if (upgrade == true) {
				System.out.println("Upgrade button is present");
			} else {
				System.out.println("Upgrade button is not present");
			}
		} catch (Exception e) {

		}
	}

	@Then("Close browser")
	public void close_browser1() {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
	}
}
