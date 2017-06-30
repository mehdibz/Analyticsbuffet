//Simple test on Sears website:

package simple;


import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.junit.Assert;


public class SearsJunitTest {

	static WebDriver webDriver=null;
	//String URL="http://www.indeed.com";
	String URL="https://www.sears.ca",text,selected=null;
	WebElement welement,wElement_1,wElement_2;
	
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
		//webDriver.manage().window().maximize();
		this.getPage();
	}
	

	// Test - 1: Add to Cart (Start from the header) 
	public int Add2Cart() throws InterruptedException{
		openBrowser();
		Thread.sleep(500);

		
		WebElement parent = SearsJunitTest.webDriver.findElement(By.id("closeWindowBtn"));
		parent.click();
		Thread.sleep(1000);

		parent = SearsJunitTest.webDriver.findElement(By.id("navigation__container"));
		parent.findElement(By.cssSelector("#navigation__container > ul > li:nth-child(3)")).click();
		
		Thread.sleep(500);
		
		parent = SearsJunitTest.webDriver.findElement(By.id("category-level-1"));
		parent.findElement(By.cssSelector("#category-level-1 > li:nth-child(5) > a")).click();
		
		Thread.sleep(500);
		
		parent = SearsJunitTest.webDriver.findElement(By.id("search-result-items"));
		parent.findElement(By.cssSelector("#search-result-items > li:nth-child(6) > div > div:nth-child(1) > div:nth-child(1) > a > img")).click();
		
		Thread.sleep(500);
		
	//	parent = SearsJunitTest.webDriver.findElement(By.id("product-content"));
		parent = SearsJunitTest.webDriver.findElement(By.id("add-to-cart"));
		parent.findElement(By.id("add-to-cart")).click();


		
		Thread.sleep(2000);
		closeBrowser();
		return 0;
	}
	
	// Test - 2: Creating Account  
	public String MyAccount_Registering() throws InterruptedException{
		openBrowser();
		Thread.sleep(1000);
		
		welement = webDriver.findElement(By.id("closeWindowBtn"));
		welement.click();
		Thread.sleep(1000);
		
		welement = webDriver.findElement(By.cssSelector("#wrapper > div.top-nav-container > div > ul > li.user-info > a"));
		Actions act= new Actions(webDriver);
		act.moveToElement(welement).perform();
		List<WebElement> Links=  webDriver.findElements(By.cssSelector("#wrapper > div.top-nav-container > div > ul > li.user-info > div > div"));
		
		wElement_1=null;
		text=null;
		byte j=3;
		for(byte i=0;i<Links.size();i++){
			
			wElement_1= Links.get(i);
			text=wElement_1.getAttribute("innerHTML");
			 
			if(text.contains("Register")){
				selected="Register";
				j=i;
			}
		}
		
		if(selected.equalsIgnoreCase("Register")){
			Links.get(j).click();
		}
	
		Thread.sleep(1000);
		closeBrowser();
		return selected;
	}

	// Test - 3: SignIn into Account
	public String MyAccount_SignIn() throws InterruptedException{
		openBrowser();
		Thread.sleep(1000);
		
		welement = webDriver.findElement(By.id("closeWindowBtn"));
		welement.click();
		Thread.sleep(1000);
		
		welement = webDriver.findElement(By.cssSelector("#wrapper > div.top-nav-container > div > ul > li.user-info > a"));
		Actions act= new Actions(webDriver);
		act.moveToElement(welement).perform();
		//List<WebElement> Links=  webDriver.findElements(By.cssSelector("#wrapper > div.top-nav-container > div > ul > li.user-info > div > div > a"));
		List<WebElement> Links=  webDriver.findElements(By.xpath("//*[@id='wrapper']/div[1]/div/ul/li[3]/div/div/a"));
		
		wElement_2=null;
		text=null;
		byte j=3;
		for(byte i=0;i<Links.size();i++){
			
			wElement_2= Links.get(i);
			text=wElement_2.getAttribute("innerHTML");
			
			if(text.contains("Sign In")){
				selected="SignIn";
				j=i;
			}
		}
		
		if(selected.equalsIgnoreCase("SignIn")){
			Links.get(j).click();
		}
		
		Thread.sleep(1000);
		closeBrowser();
		return selected;
	}
	
	@Test // Test - 4: Testing method of MyAccount_Registering() 
	public void Registering_Test() throws InterruptedException{
		Assert.assertEquals("Register", MyAccount_Registering());
	}
	
	@Test	// Test - 5: Testing method of MyAccount_SignIn() 
	public void SignIn_Test() throws InterruptedException{
		Assert.assertEquals("SignIn", MyAccount_SignIn());
	}
	
	@Test	// Test - 6: Testing method of MyAccount_SignIn() 
	public void AddToCart_Test() throws InterruptedException{
		Assert.assertEquals(0, Add2Cart());
	}
	
}

