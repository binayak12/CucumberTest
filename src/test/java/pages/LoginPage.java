package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage{
	
	private WebDriver driver;
	private String loginPageUrl;
	
	@FindBy (id = "user-name")
	private WebElement unameField;
	
	@FindBy (id = "password")
	private WebElement pwdField;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.loginPageUrl = "https://www.saucedemo.com/";
	}
	
	public void enterUsername(String username) {
		unameField.clear();
		unameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		pwdField.clear();
		pwdField.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String getToLoginPage() {
		driver.get(loginPageUrl);
		return loginPageUrl;
	}

}
