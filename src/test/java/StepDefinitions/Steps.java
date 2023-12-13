package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	static ChromeDriver driver;
	
	public static WebDriverWait wait ;
	
	
	@Before()
	public void startdriver() {
	System.out.println(System.getProperty("user.dir")+"/src/test/java/features/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/features/chromedriver.exe" );
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.navigate().to("https://www.rewe.de/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	
	
	@Given("bos bos bos")
	public void bos_bos_bos() {
	    System.out.println("a7aaaaaaaaaaaaaaaaaaaa");
	}











	
	@After()
	public void takeScreenshotOnFailure(Scenario scenario) {

		if (scenario.isFailed()) {
			
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","");
		}
		//try remove the wait to check the error of socet
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		driver.quit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}







}
