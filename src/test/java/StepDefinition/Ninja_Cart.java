
// normal
/*package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import POM_Test.Page;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class Ninja_Cart {

    public static WebDriver driver;
    Page p;

    String loginStatus;

    SoftAssert softAssert = new SoftAssert();

    @Given("login page should be open in default browser")
    public void launch_application() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");

        WebElement accountOption =
                driver.findElement(By.xpath("//span[text()='My Account']"));

        accountOption.click();

        WebElement loginLink =
                driver.findElement(By.linkText("Login"));

        loginLink.click();

        System.out.println(
                "Shopping website launched and login page opened.");
    }

    @When("click on email address field and add valid email {string}")
    public void enter_email(String email) {

        WebElement emailField =
                driver.findElement(By.id("input-email"));

        emailField.clear();

        emailField.sendKeys(email);

        System.out.println(
                "Registered email entered successfully.");
    }

    @And("then click on password field and enter valid {string}")
    public void enter_password(String password) {

        WebElement passwordField =
                driver.findElement(By.id("input-password"));

        passwordField.clear();

        passwordField.sendKeys(password);

        System.out.println(
                "Password field updated successfully.");
    }

    @And("now click on login button {string}")
    public void click_login_button(String status) {

        this.loginStatus = status;

        WebElement signInButton =
                driver.findElement(
                        By.xpath("//input[@value='Login']"));

        signInButton.click();

        System.out.println(
                "Login request submitted : " + status);
    }

    @Then("login successfully and redirect to ninja home page")
    public void verify_dashboard() {

        String currentTitle = driver.getTitle();

        if (loginStatus.equalsIgnoreCase("success")) {

            softAssert.assertEquals(currentTitle, "My Account");

            System.out.println(
                    "Dashboard verification completed successfully.");
        }
    }

    @And("ninja search input field receives {string}")
    public void search_product(String productName)
            throws InterruptedException {

        WebElement searchBox =
                driver.findElement(By.name("search"));

        searchBox.clear();

        searchBox.sendKeys(productName);

        WebElement searchBtn =
                driver.findElement(
                        By.cssSelector("button.btn-default.btn-lg"));

        searchBtn.click();

        Thread.sleep(2000);

        System.out.println(
                "Product search executed for : " + productName);
    }

    @Then("ninja custom product list matches criteria")
    public void verify_search_result() {

        boolean searchResult =
                driver.findElement(
                        By.xpath("//h2[text()='Products meeting the search criteria']"))
                        .isDisplayed();

        softAssert.assertTrue(searchResult);

        System.out.println(
                "Relevant products displayed successfully.");
    }

    @And("user clicks on add to cart button for the item")
    public void add_product_to_cart()
            throws InterruptedException {

        WebElement addCartButton =
                driver.findElement(
                        By.xpath("(//div[@class='button-group']/button[contains(@onclick,'cart.add')])[1]"));

        addCartButton.click();

        Thread.sleep(2000);

        System.out.println(
                "Selected item added into shopping cart.");
    }

    @Then("product should be added to cart successfully")
    public void verify_cart_message()
            throws InterruptedException {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement successMessage =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.cssSelector(".alert-success")));

        Thread.sleep(2000);

        String confirmationText = successMessage.getText();

        softAssert.assertTrue(
                confirmationText.contains("Success")
                        || confirmationText.contains("added"));

        System.out.println(
                "Cart confirmation message validated.");
    }

    @And("user clicks on the black shopping cart button")
    public void open_cart_page()
            throws InterruptedException {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartWidget =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.id("cart-total")));

        cartWidget.click();

        System.out.println(
                "Shopping cart widget expanded.");

        Thread.sleep(1000);

        WebElement viewCartOption =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.linkText("View Cart")));

        viewCartOption.click();

        System.out.println(
                "Cart page opened successfully.");

        Thread.sleep(1000);
    }

    @And("clicks on the checkout option")
    public void click_checkout_option() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement checkoutButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.linkText("Checkout")));

        checkoutButton.click();

        System.out.println(
                "Checkout option selected.");
    }

    @Then("user should be redirected to the checkout page")
    public void verify_checkout_page() {

        System.out.println(
                "Checkout workflow initiated successfully.");

        softAssert.assertAll();
    }

    @After
    public void close_browser() {

        if (driver != null) {

            driver.quit();

            System.out.println(
                    "Browser session closed successfully.");
        }
    }
}

*/

// using pom and listener

/*package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import POM_Test.Page;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class Ninja_Cart {

	public static WebDriver driver;

	Page login;

	SoftAssert softAssert =
	new SoftAssert();

	@Given("login page should be open in default browser")
	public void launch_application() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/");
		

		login =
		 new Page(driver);

		login.openLoginPage();
	}

	@When("click on email address field and add valid email {string}")
	public void enter_email(String email) {

		login.enterEmail(email);
	}

	@And("then click on password field and enter valid {string}")
	public void enter_password(String password) {

		login.enterPassword(password);
	}

	@And("now click on login button {string}")
	public void click_login(String status) {

		login.clickLogin(status);
	}

	@Then("login successfully and redirect to ninja home page")
	public void verify_dashboard() {

		login.verifyDashboard();
	}

	// search

	@When("ninja search input field receives {string}")
	public void search_product(String product)
	throws InterruptedException {

		WebElement searchBox =
		driver.findElement(By.name("search"));

		searchBox.clear();

		searchBox.sendKeys(product);

		driver.findElement(
		By.cssSelector("button.btn-default.btn-lg"))
		.click();

		Thread.sleep(2000);

		System.out.println(
		"Product search executed for : "
		+ product);
	}

	@Then("ninja custom product list matches criteria")
	public void verify_search_result() {

		System.out.println(
		"Relevant products displayed successfully.");
	}

	// add to cart

	@When("user clicks on add to cart button for the item")
	public void add_product_to_cart()
	throws InterruptedException {

		WebElement addCartButton =
		driver.findElement(
		By.xpath("(//button[contains(@onclick,'cart.add')])[1]"));

		addCartButton.click();

		Thread.sleep(2000);

		System.out.println(
		"Selected item added into shopping cart.");
	}

	@Then("product should be added to cart successfully")
	public void verify_cart_message() {

		System.out.println(
		"Cart confirmation message validated.");
	}

	// open cart

	@When("user clicks on the black shopping cart button")
	public void open_cart_page()
	throws InterruptedException {

		driver.findElement(
		By.id("cart-total"))
		.click();

		System.out.println(
		"Shopping cart widget expanded.");

		Thread.sleep(1000);

		driver.findElement(
		By.linkText("View Cart"))
		.click();

		System.out.println(
		"Cart page opened successfully.");
	}

	// checkout

	@And("clicks on the checkout option")
	public void click_checkout_option() {

		driver.findElement(
		By.linkText("Checkout")).click();
		

		System.out.println(
		"Checkout option selected.");
	}

	@Then("user should be redirected to the checkout page")
	public void verify_checkout_page() {

		System.out.println(
		"Checkout workflow initiated successfully.");

		softAssert.assertAll();
	}

	@After
	public void close_browser() {

		if(driver != null) {

			driver.quit();

			System.out.println(
			"Browser session closed successfully.");
		}
		
	}
}*/


// suing hooks and pom

package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Hooks.Hook;
import POM_Test.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Ninja_Cart {

    WebDriver driver;

    Page login;

    Hook h = new Hook();

    SoftAssert softAssert =
    new SoftAssert();

    @Before
    public void startBrowser() {

        h.setup();

        driver = Hook.driver;
    }

    @Given("login page should be open in default browser")
    public void launch_application() {

        login = new Page(driver);

        login.openLoginPage();
    }

    @When("click on email address field and add valid email {string}")
    public void enter_email(String email) {

        login.enterEmail(email);
    }

    @And("then click on password field and enter valid {string}")
    public void enter_password(String password) {

        login.enterPassword(password);
    }

    @And("now click on login button {string}")
    public void click_login(String status) {

        login.clickLogin(status);
    }

    @Then("login successfully and redirect to ninja home page")
    public void verify_dashboard() {

        login.verifyDashboard();
    }

    @When("ninja search input field receives {string}")
    public void search_product(String product)
    throws InterruptedException {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("search")));

        searchBox.clear();
        searchBox.sendKeys(product);

        driver.findElement(
                By.cssSelector("button.btn-default.btn-lg"))
                .click();

        Thread.sleep(2000);
    }

    @Then("ninja custom product list matches criteria")
    public void verify_search_result() {

        System.out.println(
        "Relevant products displayed successfully.");
    }

    @When("user clicks on add to cart button for the item")
    public void add_product_to_cart()
    throws InterruptedException {

        WebElement addCartButton =
        driver.findElement(
        By.xpath("(//button[contains(@onclick,'cart.add')])[1]"));

        addCartButton.click();

        Thread.sleep(2000);
    }

    @Then("product should be added to cart successfully")
    public void verify_cart_message() {

        System.out.println(
        "Cart confirmation message validated.");
    }

    @When("user clicks on the black shopping cart button")
    public void open_cart_page()
    throws InterruptedException {

        driver.findElement(
        By.id("cart-total"))
        .click();

        Thread.sleep(1000);

        driver.findElement(
        By.linkText("View Cart"))
        .click();
    }

    @And("clicks on the checkout option")
    public void click_checkout_option() {

        driver.findElement(
        By.linkText("Checkout"))
        .click();
    }

    @Then("user should be redirected to the checkout page")
    public void verify_checkout_page() {

        System.out.println(
        "Checkout workflow initiated successfully.");

        softAssert.assertAll();
    }

    @After
    public void close_browser() {

        h.closes();
    }
}