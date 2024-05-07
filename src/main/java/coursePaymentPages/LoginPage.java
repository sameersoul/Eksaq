package coursePaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;



   public LoginPage(WebDriver driver) {
	   
	   this.driver=driver;
   }
   
   //defining login page elements and its methods
   By clickLogin    = By.xpath("//a[.='Login']");
   By userNameField = By.xpath("//input[@id='wdm_username']");
   By passwordField = By.xpath("//input[@id='wdm_password']");
   By loginButton   = By.xpath("//input[@value='Login']");
   
   
   public void clickLogin() {
	   driver.findElement(clickLogin).click();
   }
   public void enterUserName(String Username) {
	   driver.findElement(userNameField).sendKeys(Username);
   }
   
   public void enterPassword(String Password) {
	   driver.findElement(passwordField).sendKeys(Password);
   }
   
   public void clickLoginButton() {
	   driver.findElement(loginButton).click();
   }
}