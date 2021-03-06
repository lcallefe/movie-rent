package runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class) 
@CucumberOptions(
	features="./src/test/resources/Features/contas.feature",
	glue={"steps"},
	monochrome = true,
	dryRun = false,
	plugin = { "pretty", "json:target/JSONReports/report.json"}
	)
public class TestRunner {
	@BeforeClass //é executado antes que a classe seja executada
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.id("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}


