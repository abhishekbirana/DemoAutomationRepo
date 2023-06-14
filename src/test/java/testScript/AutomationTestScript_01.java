package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationTestScript_01 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.careinsurance.com/rhicl/proposalcp/renew/index-care");
	driver.findElement(By.id("policynumber")).sendKeys("12345");
	
	driver.findElement(By.id("dob")).click();
	
	WebElement month = driver.findElement(By.className("ui-datepicker-month"));
	Select MONTH=new Select(month);
	MONTH.selectByValue("7");
	
	WebElement year = driver.findElement(By.className("ui-datepicker-year"));
	Select YEAR=new Select(year);
	YEAR.selectByVisibleText("1980");
	
	driver.findElement(By.xpath("//a[text()='15']")).click();
	
	driver.findElement(By.id("alternative_number")).sendKeys("9876543210");
	Thread.sleep(20000);
	
	driver.findElement(By.id("renew_policy_submit")).submit();
	
	
	
	
	
}
}
