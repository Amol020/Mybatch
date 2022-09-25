package Mybank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "(//div[contains(@class,'absolute')])[3]")
	private WebElement login;
	
	@FindBy(xpath = "//input[@id='login_email1']")
	private WebElement email;
	
	@FindBy(xpath = "(//div[contains(@class,'ParentDimension')])[1]")
	private WebElement process;
	
	@FindBy(xpath = "//input[@id='login_password1']")
	private WebElement password;
	
	@FindBy(xpath = "(//div[contains(@class,'ParentDimension')])[1]")
	private WebElement submit;
	
	@FindBy(xpath = "(//input[@type='number'])[1]")
	private WebElement otp;
	
	//@FindBy(xpath = "(//input[@type='password'])[1]")
	//private WebElement otp;
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void openLogin() {
		login.click();
	}
	
	public void openProcess() {
		email.sendKeys("pamol020@gmail.com");
		process.click();
	}
	
	public void openSubmit() {
		password.sendKeys("selenium@2105");
		submit.click();
	}
	
	public void enterOtp() throws InterruptedException {
		 otp.sendKeys("4465");
		 Thread.sleep(3000);
	}

}
