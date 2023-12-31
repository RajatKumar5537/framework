package practicepackage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class soalinktest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.soa.ac.in/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count=links.size();
		System.out.println(count);
		ArrayList<String> storeLinks=new ArrayList<String>();

		for (WebElement webElement : links) {

			String eachLink=webElement.getAttribute("href");

			URL url=null;
			int statuscode=0;

			try {
				url=new URL(eachLink);
				HttpsURLConnection https=(HttpsURLConnection) url.openConnection();
				statuscode=https.getResponseCode();

				if(statuscode>=400) {

					storeLinks.add(eachLink+"----------->"+statuscode);
				}
			} 

			catch (Exception e) {
				storeLinks.add(eachLink+"----------->"+statuscode);
			}
		}

		System.out.println(storeLinks);
		driver.close();

	}

}
