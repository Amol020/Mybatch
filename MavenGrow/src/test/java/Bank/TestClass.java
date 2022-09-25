package Bank;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Mybank.Holdings;
import Mybank.HomePage;
import Mybank.LoginPage;

public class TestClass {
	
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32(1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://groww.in/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLogin();
		loginPage.openProcess();
		loginPage.openSubmit();
		loginPage.enterOtp();

		
		HomePage homepage = new HomePage(driver);
		homepage.openInvestment();
		Thread.sleep(3000);
		
		Holdings holdings = new Holdings(driver);
		holdings.openOrders();
		holdings.profilelogout();
		
	}

}
