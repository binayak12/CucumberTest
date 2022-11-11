package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	
	public static WebDriver getDriver(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			return driver;
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			return driver;
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		}
	}
	
	public static WebDriver getDriver() {
		Properties browser = new Properties();
		FileInputStream browserFile;
		try {
			browserFile = new FileInputStream("src/test/resources/config/browserSetup.property");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver = getDriver("Chrome");
			return driver;
		}
		try {
			browser.load(browserFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver = getDriver("Chrome");
			return driver;
		}
		String browserName = browser.get("browserName").toString();
		driver = getDriver(browserName);
		return driver;
	}

}
