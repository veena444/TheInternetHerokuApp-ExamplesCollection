package exampleCollections;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		//find all the links using tagName 'a'
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links: "+links.size());
		
		//iterate to get all 'href' attribute
		for(WebElement e : links) {
			String url = e.getAttribute("href");
			checkBrokenLink(url);

		}
			
		driver.quit();
	}
	
	// method to verify broken links
	
	public static void checkBrokenLink(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode() >= 400) {
				System.out.println(linkUrl+ " ---->" +httpURLConnection.getResponseMessage() +" is a broken link");
			}
			else {
				System.out.println(linkUrl +" ----->" +httpURLConnection.getResponseMessage() );
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
