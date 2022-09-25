package Mybank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Holdings {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//a[text()='VIEW ALL ORDERS']")
	private WebElement orders;
	
	@FindBy(xpath="(//div[@class='valign-wrapper'])[1]")
	private WebElement openprofile;
	
	@FindBy(xpath="//div[text()='Log Out']")
	private WebElement logout;
	
	public Holdings(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void openOrders() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(orders));
		orders.click();
	}
	
	public void profilelogout() {
		openprofile.click();
		logout.click();
		
	}

}
