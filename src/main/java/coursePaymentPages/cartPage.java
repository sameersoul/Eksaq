package coursePaymentPages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage {

	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//define cartpage elements and its methods
	
	By cartIcon =By.xpath("(//a[@href='https://uat.eksaqonline.com/index.php/cart-2/'])[3]");
	
	By checkout =By.xpath("(//a[@href='https://uat.eksaqonline.com/index.php/checkout/'])[3]");
	
	By firstname =By.xpath("//input[@name='billing_first_name']");
	
	By lastname =By.xpath("//input[@name='billing_last_name']");
	
	By billingAddress= By.xpath("//input[@name='billing_address_1']");
	
	By billingCity =By.xpath("//input[@name='billing_city']");
	
	By selectState = By.xpath("//select[@name='billing_state']");
	
	By postcode   = By.xpath("//input[@name='billing_postcode']");
	
	By phone      = By.xpath("//input[@name='billing_phone']");
	
	By email      = By.xpath("//input[@name='billing_email']");
	
	By placeOrder = By.xpath("//button[@name='woocommerce_checkout_place_order']");
	
	
	public void clickCart() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		Boolean flag=wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon)).isDisplayed();
		assertTrue(flag,"Cart icon is not displayed, test failed");
		wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon)).click();
	
	}	
	
	
	public void clickCheckOut() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("Cart – EKSAQ"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(checkout).click();
	}
	
	public void enterFNameNLName(String FirstName, String LastName) {
		driver.findElement(firstname).sendKeys(FirstName);
		driver.findElement(lastname).sendKeys(LastName);
	}
	
	public void enterAddress(String homeAddress,String City) {
		driver.findElement(billingAddress).sendKeys(homeAddress);
		driver.findElement(billingCity).sendKeys(City);
	}
	
	public void selectState() {
		Select s= new Select(driver.findElement(selectState));
		s.selectByVisibleText("Andhra Pradesh");
	}
	
	public void enterContactDetails(String PhoneNo, String Email) {
		driver.findElement(phone).sendKeys(PhoneNo);
		driver.findElement(email).sendKeys(Email);	
		}
	
	// Scroll to a specific element on the page
    public void scrollDown() {
   	 JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
     
     public void placeOrder() {
    	 driver.findElement(placeOrder).click();
     }
        
        
}

    
