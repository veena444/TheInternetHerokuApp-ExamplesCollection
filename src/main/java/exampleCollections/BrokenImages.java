package exampleCollections;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		//find all the images using tagName 'img'
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		//iterate & get the attribute of src
		for(WebElement e : imagesList) {
			String url = e.getAttribute("src");
			verifyBrokenImages(url);
		}
		driver.quit();

	}
	
	//method to verify broken images
	
	public static void verifyBrokenImages(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode() != 200) {
				System.out.println(linkUrl+ " ---->" +httpUrlConnection.getResponseMessage() +" is a broken image");
			}
			else {
				System.out.println(linkUrl +" ----->" +httpUrlConnection.getResponseMessage() );
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
