package exampleCollections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ABTesting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).click();
		String actualHeader = "A/B Test Control";
		String expectedHeader = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		if(actualHeader.equals(expectedHeader)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		driver.quit();

	}

}
