package exampleCollections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement sourceElement = driver.findElement(By.id("column-a"));
		WebElement targetElement = driver.findElement(By.id("column-b"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(sourceElement, targetElement).perform();
		
		String boxAText = driver.findElement(By.id("column-a")).getText();
		
		if(boxAText.equals("B")) {
			System.out.println("Drag & Drop verified successfully");
		}
		else {
			System.out.println("Drag & Drop verification failed");
		}
		
		driver.quit();
		
	}

}
