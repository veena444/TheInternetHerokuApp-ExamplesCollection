package exampleCollections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		String username ="admin";
		String password = "admin";
		
		
		//syntax for url with basic auth : https://username:password@website.com
		driver.get("https://"+username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
		
		driver.quit();
		


	}

}
