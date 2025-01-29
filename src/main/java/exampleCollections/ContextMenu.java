package exampleCollections;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/context_menu");
		
		//right click on context box to locate the element
		WebElement contextBox = driver.findElement(By.id("hot-spot"));
		
		//right click on context box
		Actions action = new Actions(driver);
		action.contextClick(contextBox).perform();
		
		//handle the JavaScript alert
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.quit();

	}

}
