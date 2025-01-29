package exampleCollections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
		
		//verify if checkbox is already selected
		if(!checkbox1.isSelected()) {
			checkbox1.click();
			System.out.println("checkbox is now selected");
		}
		else {
			System.out.println("checkbox was already selected");;
		}
		
		if(checkbox2.isSelected()) {
			checkbox2.click();
			System.out.println("checkbox is now deselected");
		}
		else {
			System.out.println("checkbox was already deselected");
		}
		
		System.out.println((checkbox1.isSelected() ? "Selected":"Not Selected"));
		System.out.println((checkbox2.isSelected() ? "Selected":"Not Selected"));
		
		driver.quit();

	}

}
