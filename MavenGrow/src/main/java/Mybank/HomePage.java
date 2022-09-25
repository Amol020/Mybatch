package Mybank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;

	
	
	
	@FindBy(xpath = "//a[text()='Investments']")
	private WebElement investment;
	
	@FindBy(xpath = "//input[@id='globalSearch23']")
	private WebElement search;
	
	@FindBy(xpath = "//div[text()='Mutual Funds']")
	private WebElement mutualFunds;
	
	@FindBy(xpath = "//div[text()='US Stocks']")
	private WebElement usStocks;
	
	@FindBy(xpath = "//div[text()='Fixed Deposits']")
	private WebElement fixedDeposite;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void openInvestment() {
	
		investment.click();
		
	}

}
