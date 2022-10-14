package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wappalazer {

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wappalyzer.com");
		driver.manage().window().maximize();
	}

	@Test
	public void Resources()
	{
		driver.findElement(By.xpath("//div[@class='v-toolbar__content']/div[1]/div[1]/div[2]/button[2]")).click();
	}
	@Test
	public void Technologies()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='v-toolbar__content']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a/div[1]")).click();
	}
	@Test
	public void search() throws InterruptedException  
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='container py-10 py-sm-12']/div[1]/div[2]/h2[2]"));
	
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='v-select__selections']"));
		
		element1.click();
		driver.findElement(By.xpath("//div[@role='listbox']/form[1]/div[1]/div[1]/div[1]/div[1]/input")).sendKeys("Stripe");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@role='listbox']/div[1]")).click();
	}
	
	@Test
	public void clickLead()
	{
		driver.findElement(By.xpath("//div[@class='v-alert__content']/a[1]")).click();
	}

	@AfterTest
    public void browserclose()
    {
        driver.quit();
    }
	
}
