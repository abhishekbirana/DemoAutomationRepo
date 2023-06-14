package testScript;

import java.io.FileInputStream; 
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagram_ATS {

	public static void main(String[] args) throws IOException {
		// Fetching the data from Property File
		FileInputStream fis = new FileInputStream("./data/Instagram_Credential.property");
		Properties p = new Properties();
		p.load(fis);

		String username = p.getProperty("username");
		String password = p.getProperty("password");

		// Checking the Username and Password are acceptable or not
		if (password.length() >= 6 && username.length() > 0) {
			System.out.println("Welcome! Instagram Web Application is openning.");

			// Opening the Browser
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			// Hit the URL
			driver.get("https://www.instagram.com/");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Login to Application with fetched data from Property File
			driver.findElement(By.name("username")).sendKeys(username);

			driver.findElement(By.name("password")).sendKeys(password);

			driver.findElement(By.xpath("//div[text()='Log in']")).click();

			// Printing the Message which is showing after Login
			String data = driver.findElement(By.id("slfErrorAlert")).getText();

			System.out.println(data);

			// Validation
			if (data.contains("incorrect")) {
				System.out.println("Login Unsuccesfull");
				System.out.println("=== FAIL ===");
			} else {
				System.out.println("Login Succesfull");
				System.out.println("=== PASS ===");
			}

			driver.close();
		} else {
			System.out.println("Please Enter Valid Password, Your Password length is less than required");
		}
	}
}
