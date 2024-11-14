package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	
	@Before
	public void before() {
		System.out.println("Before");
	}
	@After
	public void after() {
		System.out.println("After");
	}
	
	@Given("the user enters into the website")
	public void the_user_enters_into_the_website() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		//opening the page
		driver.get("https://ezway2connect.com/career-advisor/");
		System.out.println(driver.getTitle());
	}

	@Given("the user hits book-now")
	public void the_user_hits_book_now() throws InterruptedException {
		driver.findElement(By.linkText("Book Now")).click();
		Thread.sleep(400);
	}

	@When("the user clicks any date and picks time")
	public void the_user_clicks_any_date_and_picks_time() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class=\"c-day-content\"]/div[contains(text(),'27')]")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("//div[@id='am-appointment-times0']/div/div/label[8]/span")).click();
		driver.findElement(By.xpath("//button[@id='am-continue-button']/span")).click();
		Thread.sleep(400);
	}

	@Then("the user should be able to fillup the payment form")
	public void the_user_should_be_able_to_fillup_the_payment_form() {
		driver.findElement(By.xpath("//input[@name='given-name']")).sendKeys("Maksuda");
		driver.findElement(By.xpath("//input[@name='family-name']")).sendKeys("Akter");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Akter@html.com");
		
		driver.findElement(By.xpath("//input[@name='tel']")).sendKeys("4109294423");
		WebElement e= driver.findElement(By.xpath("//*[contains(text(), 'Please enter a valid phone number')]"));
		System.out.println(e.getText()); 
		driver.findElement(By.xpath("//div[@id='am-confirm-booking']/div[1]/div[3]/div[3]/span")).click();
	}
}
