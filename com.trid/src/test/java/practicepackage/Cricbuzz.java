package practicepackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricbuzz {

	public static void main(String[] args) {
		//String player="Mitchell Marsh";
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//a[@id='live-scores-link']")).click();
		driver.findElement(By.xpath("//a[@id='recent-tab']")).click();
		driver.findElement(By.xpath("//a[@title='Australia vs India 3rd ODI']//div[@class='cb-scr-wll-chvrn']")).click();
        driver.findElement(By.xpath("//a[@title='India vs Australia, 3rd ODI Scorecard']")).click();
	  
        
        List<WebElement> allName = driver.findElements(By.xpath("//span[text()='Australia Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-25 ']"));
        for(WebElement ele:allName) {
        	
        }
        driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-25 ']/ancestor::div[@class='cb-col cb-col-25 ']/"));
	}

}
