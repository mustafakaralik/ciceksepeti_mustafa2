package com.ciceksepeti.step_definitions;

import com.ciceksepeti.utilities.ConfigurationReader;
import com.ciceksepeti.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinition {

    @Given("the user is on home page")
    public void the_user_is_on_home_page() {
      String HomePage = ConfigurationReader.get("url") ;
        Driver.get().get(HomePage);
    }

    @When("the user should not be able to login with invalid {string} valid {string}")
    public void the_user_should_not_be_able_to_login_with_invalid_valid(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
