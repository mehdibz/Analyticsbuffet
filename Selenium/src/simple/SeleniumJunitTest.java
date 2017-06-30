//Simple test on Indeed website:

package simple;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumJunitTest {

	static WebDriver webDriver=null;
	//String URL="http://www.indeed.com";
	String URL="https://www.sears.ca/";
	
	@BeforeClass
	public static void init(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Mehdi\\Downloads\\selenium-java-3.0.1\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mehdi\\Downloads\\selenium-java-3.0.1\\chromedriver.exe");
	}
	
	public static void closeBrowser() {
		webDriver.quit();
	}

	public void getPage() {
		webDriver.get(URL);
	}

	public void openBrowser() {
		//webDriver=new FirefoxDriver();
		webDriver=new ChromeDriver();
		this.getPage();
	}
	
	@Ignore
	@Test  // Test - 1 : Simple search test
	public void mainTest() throws InterruptedException  {
		openBrowser();
		
		Thread.sleep(2000);
		SeleniumJunitTest.webDriver.findElement(By.id("what")).sendKeys("Selenium");
		
		Thread.sleep(2000);
		SeleniumJunitTest.webDriver.findElement(By.id("where")).clear();
		SeleniumJunitTest.webDriver.findElement(By.id("where")).sendKeys("London");
		
		Thread.sleep(2000);
		SeleniumJunitTest.webDriver.findElement(By.id("fj")).click();
		
		Thread.sleep(2000);
		System.out.println(SeleniumJunitTest.webDriver.findElement(By.id("searchCount")).getText());
		System.out.println(SeleniumJunitTest.webDriver.getTitle());
		closeBrowser();
	}
	@Ignore
	@Test // Test - 2: Validation of header links 
	public void LinksTest() throws InterruptedException  {

		openBrowser();

		Thread.sleep(2000);
		SeleniumJunitTest.webDriver.findElement(By.id("rezLink")).click();
		Thread.sleep(3000);
		SeleniumJunitTest.webDriver.findElement(By.id("jobsLink")).click();
		Thread.sleep(3000);
		SeleniumJunitTest.webDriver.findElement(By.id("userOptionsLabel")).click();
		Thread.sleep(3000);
		closeBrowser();
	}
	
	@Test	// Test - 3: Sears hyper links at the header 
	public void sears() throws InterruptedException{
		openBrowser();
		Thread.sleep(500);
		
		WebElement parent = SeleniumJunitTest.webDriver.findElement(By.id("closeWindowBtn"));
		parent.click();
		parent = SeleniumJunitTest.webDriver.findElement(By.id("navigation__container"));
		
		Thread.sleep(1000);
		
		//parent = parent.findElement(By.tagName("ul"));
		parent.findElement(By.cssSelector("#navigation__container > ul > li:nth-child(3)")).click();
		
		Thread.sleep(500);
		
		parent = SeleniumJunitTest.webDriver.findElement(By.id("category-level-1"));
		parent.findElement(By.cssSelector("#category-level-1 > li:nth-child(5) > a")).click();
		
		Thread.sleep(500);
		
		parent = SeleniumJunitTest.webDriver.findElement(By.id("search-result-items"));
		parent.findElement(By.cssSelector("#search-result-items > li:nth-child(6) > div > div:nth-child(1) > div:nth-child(1) > a > img")).click();
		
		Thread.sleep(500);
		
		parent = SeleniumJunitTest.webDriver.findElement(By.id("product-content"));
		parent.findElement(By.cssSelector("#add-to-cart")).click();

		Thread.sleep(500);
		
	/*	parent = SeleniumJunitTest.webDriver.findElement(By.id("mini-cart"));
		

		//parent.findElement(By.xpath("//*[@id='category-level-1']/li[5]")).click();
		
		   /*if ( descendants.length )
		      return descendants[0];
		   return null;
		*/

		//closeBrowser();
		
	}
}

