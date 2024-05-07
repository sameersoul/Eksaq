package coursePaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class coursePage {
    private WebDriver driver;
    

    public coursePage(WebDriver driver) {
        this.driver = driver;
    }
    
    //Define course page elements and its method
    
    By coursesLabel =By.xpath("//ul[@id='primary-menu']/descendant::a[4]");
    
    By selectCourse = By.xpath("//a[.='RCA Test Warangal']");
    
    By costPerStudent =By.xpath("(//input[@min='1'])[1]");
    
    By costPerTeacher =By.xpath("(//input[@min='1'])[2]");
    
    By Subscribe      = By.xpath("//button[.='Subscribe']");

    public void clickCourses() {
        driver.findElement(coursesLabel).click();
    }
    
    // Scroll to a specific element on the page
     public void scrollDown() {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    public void selectACourse() {
    	driver.findElement(selectCourse).click();
    }
    

    public void enterStudentCost(String StudentCost) {
    	driver.findElement(costPerStudent).sendKeys(StudentCost);
    }
    
    public void enterTeacherCost(String TeacherCost) {
    	driver.findElement(costPerTeacher).sendKeys(TeacherCost);
    }
    
    public void clickSubscribe() {
    	driver.findElement(Subscribe).click();
    }
}
