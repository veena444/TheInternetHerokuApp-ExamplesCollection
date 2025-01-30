package exampleCollections;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DigestAuthentication {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		((HasAuthentication)driver).register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/digest_auth");
		
		System.out.println(driver.getTitle());
		
		String expectedMsg = "Congratulations! You must have the proper credentials.";
		String actualMsg = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
		
		Assert.assertEquals(actualMsg, expectedMsg);
			
		
		
		driver.quit();

	}

}
