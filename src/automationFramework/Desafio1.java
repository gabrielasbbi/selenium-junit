package automationFramework;

import org.junit.Test;
import org.junit.Before;

import java.time.Duration;

import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Desafio1 {
	private WebDriver driver;

	@Before
	public void setUp() {
		//!!IMPORTANT!! Modify following path to your correct chromedriver location.
		System.setProperty("webdriver.chrome.driver", "E:\\java-workspace\\Sicredi\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		// Quits driver.
		driver.quit();
	}
	
	@Test
	public void desafio1() throws InterruptedException {
		driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4");

		// Gets select element
		Select themeSelect = new Select(driver.findElement(By.id("switch-version-select")));
		themeSelect.selectByValue("/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4");

		driver.findElement(By.linkText("Add Record")).click();
		driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
		driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
		driver.findElement(By.id("field-contactFirstName")).sendKeys("Alex");
		driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
		driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
		driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
		driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
		driver.findElement(By.id("field-state")).sendKeys("RS");
		driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
		driver.findElement(By.id("field-country")).sendKeys("Brasil");
		driver.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys("Fixter");
		driver.findElement(By.id("field-creditLimit")).sendKeys("200");
		driver.findElement(By.id("form-button-save")).click();

		// Gets success message by xPath and correspondent text
		WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='report-success' and contains(., 'Your data has been successfully stored into the database.')]")));
		// Verifies if the message is displayed
		successMessage.isDisplayed();
	}
}
