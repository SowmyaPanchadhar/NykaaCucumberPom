package parallel;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("I am on HRMS login page")
	public void i_am_on_hrms_login_page() {
	DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage = new LoginPage(DriverFactory.getDriver());
	}

	@Given("I have entered valid {string} and {string}")
	public void i_have_entered_valid_and(String username, String password) {
	    loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickLoginButton();

	}

	@Then("I should be logged in succesfully")
	public void i_should_be_logged_in_succesfully() {
		String accountName = loginPage.getAccountName();
		Assert.assertNotNull(accountName);
	}

	@Then("I should be redirected to homepage")
	public void i_should_be_redirected_to_homepage() {
		boolean isDashBoardDisplayed = loginPage.isDashBoardDisplayed();
		Assert.assertEquals(isDashBoardDisplayed, true);
	}

	@Given("I have entered invalid  {string} or {string}")
	public void i_have_entered_invalid_or(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	
			loginPage.clickLoginButton();

	}

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String error_message) {
		System.out.println("I am printing" + error_message);
}

	@When("I click on forgot passowrd link")
	public void i_click_on_forgot_passowrd_link() {
		loginPage.clickOnForgotLink();

	}

	@Then("I should be navigated to forgot password page to reset credentails")
	public void i_should_be_navigated_to_forgot_password_page_to_reset_credentails() {
		System.out.println(loginPage.getforgotPwdPageUrl());

	}


}
