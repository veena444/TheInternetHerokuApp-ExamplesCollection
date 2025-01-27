package exampleCollections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Add/Remove Elements')]")).click();
		
		WebElement addElementButton = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
		
		//click Add Element 5 times
		
		int elementsToAdd = 5;
		for(int i=0;i<elementsToAdd;i++) {
			addElementButton.click();
		}
		
		//verify 5 times Delete button added
		
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
		System.out.println(deleteButtons.size());
		
		if(deleteButtons.size() == elementsToAdd) {
			System.out.println("PASS; elements added successfully");
		}
		else {
			System.out.println("FAIL; count mismatch");
		}

		
		//remove all elements by clicking 'Delete' button
		
		for(WebElement deleteBtn: deleteButtons) {
			deleteBtn.click();
		}
		
		//verify all 'Delete' buttons removed
		
		try {
			deleteButtons = driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
			if(deleteButtons.isEmpty()) {
				System.out.println("PASS;all elements removed");
			}
			else {
				System.out.println("FAIL;all elements not removed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		driver.quit();
	

	}

}
