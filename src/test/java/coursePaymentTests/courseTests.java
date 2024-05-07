package coursePaymentTests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coursePaymentPages.cartPage;

public class courseTests {

	WebDriver driver;
	coursePaymentPages.LoginPage LoginPage;
	coursePaymentPages.coursePage CoursePage;
	coursePaymentPages.cartPage CartPage;
	
	@BeforeTest
	public void setup() {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://uat.eksaqonline.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Initialize Page Objects
        LoginPage = new coursePaymentPages.LoginPage(driver);
        CoursePage = new coursePaymentPages.coursePage(driver);
        CartPage  = new coursePaymentPages.cartPage(driver);
	}
	
	 @BeforeClass
	    public void testLogin() {
	        // Login
		    LoginPage.clickLogin();
	        LoginPage.enterUserName("testorguat1@mailinator.com");
	        LoginPage.enterPassword("Abcd@123");
	        LoginPage.clickLoginButton();
	
}
	 
	 
	 @Test(priority = 1)
	    public void selectCourseTest() {
	        // Initialize coursePage
	    	CoursePage = new coursePaymentPages.coursePage(driver);

	        // Click on Courses label to view all programs
	        CoursePage.clickCourses();
           
	        //scroll down to the bottom of the page
	        CoursePage.scrollDown();
	        // Select a specific course
	        CoursePage.selectACourse();

	        // Enter cost for students and teachers
	        CoursePage.enterStudentCost("1"); 
	        CoursePage.enterTeacherCost("1"); 

	        // Subscribe to the course
	        CoursePage.clickSubscribe();
	    }
	 @Test(dependsOnMethods = "selectCourseTest")
	 public void testCart() {
		//initialize cartPage
		    
	     CartPage.clickCart();
	     CartPage.clickCheckOut();
	     CartPage.enterFNameNLName("Sameer", "Shaik");
	     CartPage.enterAddress("Bhavani Nagar","Madanapalle");
	     CartPage.selectState();
	     CartPage.enterContactDetails("9502709534","sa2337308@gmail.com");
	     CartPage.scrollDown();
	     CartPage.placeOrder();
	 }

	  @AfterClass
	    public void tearDown() {
	        // Close browser
	        driver.quit();
	    }
	  }
