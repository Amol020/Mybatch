package Bank;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Mybank.Holdings;
import Mybank.HomePage;
import Mybank.LoginPage;
import setup.Base;
import utils.Utility;

public class VerifyHoldings extends Base {
	
	
	private WebDriver driver;
	private Holdings holdings;
	private LoginPage loginPage;
	private HomePage homepage;
	private Utility utility;
	private SoftAssert soft;
	int testID;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver = Chromebrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = Firefoxbrowser();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
	}
	
	@BeforeClass
	public void createPOMObjects()
	{
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		holdings = new Holdings(driver);
		
	}
	
	@BeforeMethod
	public void openHomepage() throws InterruptedException  {
		soft = new SoftAssert();
	    driver.get("https://groww.in/");
		loginPage.openLogin();
		loginPage.openProcess();
		loginPage.openSubmit();
		loginPage.enterOtp();
		
		
        String homePageURL = driver.getCurrentUrl();
		soft.assertEquals(homePageURL, "https://groww.in/stocks/user/explore");
		
		homepage.openInvestment();
        String investmentPageURL = driver.getCurrentUrl();
        soft.assertEquals(investmentPageURL, "https://groww.in/stocks/user/investments");	
		
	}
	
	@Test
	public void openHoldngs() throws InterruptedException, IOException {
		testID = 1000;
		holdings.openOrders();
		String holdingPageURL = driver.getCurrentUrl();
        String title = driver.getTitle();
        soft.assertEquals(holdingPageURL ,"https://groww.in/user/order/stocks" );
        soft.assertEquals(title ,"Dashboard - Grow" );
        soft.assertAll();	
	}
	
	@Test
	public void openHoldn() throws InterruptedException, IOException {
		testID = 1001;
		holdings.openOrders();
		String holdingPageURL = driver.getCurrentUrl();
        String title = driver.getTitle();
        soft.assertEquals(holdingPageURL ,"https://groww./user/order/stocks" );
        soft.assertEquals(title ,"Dashboard - Groww" );
        soft.assertAll();	
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		Utility.captureScreenshot(driver, testID);
		}
		holdings.profilelogout();	
	}
	
	@AfterClass
	public void cleanPOMObject()
	{
	   loginPage = null;
		homepage = null;
		holdings = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
		
	}
	
	
	
	
	
	

}
