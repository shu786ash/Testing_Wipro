/*package StepDefinition;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
 
public class LoginStep {
 
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
 
	@Given("the login page is open in the default browser")
	public void the_login_page_is_open_in_the_default_browser() {
 
		driver = new ChromeDriver();
 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
		driver.get("http://zero.webappsecurity.com/login.html");
	}
 
	@When("the user enters a valid username")
	public void the_user_enters_a_valid_username() {
 
		driver.findElement(By.id("user_login")).sendKeys("username");
	}
 
	@And("the user enters a valid password")
	public void the_user_enters_a_valid_password() {
 
		driver.findElement(By.id("user_password")).sendKeys("password");
	}
 
	@And("the user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
 
		driver.findElement(By.name("submit")).click();
	}
 
	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
 
		softAssert.assertFalse(driver.getCurrentUrl().contains("login"), "Login Failed");
	}
 
	@Then("the user should be redirected to the login home page")
	public void the_user_should_be_redirected_to_the_login_home_page() {
 
		softAssert.assertTrue(driver.getCurrentUrl().contains("bank") || driver.getCurrentUrl().contains("index"),
				"User not redirected");
	}
 
	@After
	public void closeBrowser() {
 
		driver.quit();
	}
}*/



// multiple login

/*package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class LoginStep {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@Given("the login page is open in the default browser")
	public void the_login_page_is_open_in_the_default_browser() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://zero.webappsecurity.com/login.html");
	}

	@When("the user enters username {string}")
	public void the_user_enters_username(String username1) {

		driver.findElement(By.id("user_login")).sendKeys(username1);
	}

	@And("the user enters password {string}")
	public void the_user_enters_password(String password1) {

		driver.findElement(By.id("user_password")).sendKeys(password1);
	}

	@And("the user clicks the submit button with status {string}")
	public void the_user_clicks_the_submit_button_with_status(String status) {

		driver.findElement(By.name("submit")).click();

		System.out.println("Test case Status = " + status);
	}

	@Then("verify login result {string}")
	public void verify_login_result(String status) throws InterruptedException {

		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL = " + currentUrl);

		if (status.equalsIgnoreCase("success")) {

			softAssert.assertFalse(currentUrl.contains("login"), "Login should be successful but failed");

		} else if (status.equalsIgnoreCase("fail")) {

			softAssert.assertTrue(currentUrl.contains("login"), "Login should fail but passed");
		}
	}

	@After
	public void closeBrowser() {

		if (driver != null) {
			driver.quit();
		}
	}
}
*/


// complete zero bank

package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;
	
	@Given("login page should be open i default browser")
	public void login_page_should_be_open_i_default_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/login.html");
		
//		driver.get("https://tutorialsninja.com/demo/");		
//		WebElement accntDrop =  driver.findElement(By.xpath("//span[text()='My Account']"));
//		accntDrop.click();
//		WebElement loginBtn = driver.findElement(By.linkText("Login"));
//		loginBtn.click();
	}

	@When("^click on username field and add valid user (.*)$")
	public void click_on_username_field_and_add_valid_user_username1(String username1) {
		WebElement user=driver.findElement(By.id("user_login"));
		user.sendKeys(username1);
		System.out.println("Username= "+username1);
		
//		WebElement loginEmailField = driver.findElement(By.id("input-email"));
//		loginEmailField.clear();
//		loginEmailField.sendKeys("sikder@gmail.com");
		 
		
	}

	@And("^then click on password button and enter valid (.*)$")
	public void then_click_on_password_button_and_enter_valid_password1(String password1) {
		WebElement pass=driver.findElement(By.id("user_password"));
		pass.sendKeys(password1);
		System.out.println("Password1= "+password1);
		
//		WebElement loginPasswordField  = driver.findElement(By.id("input-password"));
//		loginPasswordField.clear();
//	    loginPasswordField.sendKeys("Admin@123");
	}

	@And("^now click on submit button(.*)$")
	public void now_click_on_submit_button_Status(String status) {
		driver.findElement(By.name("submit")).click();
		System.out.println("Test Case Status= "+status);
		System.out.println("*************************************");
		
//		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
//		loginButton.click();
	}

	@Then("login successfully and redirect to home page")
	public void login_successfully_and_redirect_to_home_page() {
		
//		System.out.println("Login successfully done");
		driver.quit();
	}

}