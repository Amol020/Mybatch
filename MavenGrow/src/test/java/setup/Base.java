package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver Chromebrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32(1)\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    return driver;	
	}
	
	public static WebDriver Firefoxbrowser() {
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    return driver;	
	}

}
