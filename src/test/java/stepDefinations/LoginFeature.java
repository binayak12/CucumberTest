package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.BrowserFactory;

public class LoginFeature {
	
	static WebDriver driver;
	static LoginPage loginPg;
	
	
	@Given("we are in login page")
	public static void we_are_in_login_page() {
		driver = BrowserFactory.getDriver();
		driver.manage().window().maximize();
		loginPg = PageFactory.initElements(driver, LoginPage.class);
		loginPg.getToLoginPage();
	}

	@When("we enter usermane {} and password {}")
	public static void we_enter_usermane_and_password(String username, String password) {
		loginPg.enterUsername(username);
		loginPg.enterPassword(password);
	}
	
	@And("click login button")
	public static void click_login_button() {
		loginPg.clickLoginBtn();
	}
	
	@Then("we get redirected to inventory page")
	public static void we_get_redirected_to_inventory_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	
	@Then("error message appeares")
	public static void error_message_appeares() {
		Assert.assertTrue(!driver.findElements(By.cssSelector("button.error-button")).isEmpty());
	}

	
	@After
	public static void close() {
		driver.quit();
	}

}
