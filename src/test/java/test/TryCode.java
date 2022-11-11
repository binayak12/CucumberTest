package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import utils.BrowserFactory;

public class TryCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = BrowserFactory.getDriver();
		
		driver.manage().window().maximize();
		
		LoginPage loginPg = PageFactory.initElements(driver, LoginPage.class);
		
		loginPg.getToLoginPage();
		
		loginPg.enterUsername("aa");
		loginPg.enterPassword("dd");
		loginPg.clickLoginBtn();
		
		Boolean exists = !driver.findElements(By.cssSelector("button.error-button")).isEmpty();
		
		System.out.println(exists);
	}
}
