package com.ciceksepeti.step_definitions;

import com.ciceksepeti.pages.LoginPage;
import com.ciceksepeti.utilities.BrowserUtils;
import com.ciceksepeti.utilities.ConfigurationReader;
import com.ciceksepeti.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinition {

    @Given("the user is on home page")
    public void the_user_is_on_home_page() {
      String HomePage = ConfigurationReader.get("url") ;
        Driver.get().get(HomePage);

    }

    @When("the user should not be able to login with invalid {string} valid {string}")
    public void the_user_should_not_be_able_to_login_with_invalid_valid(String email, String password) {
    new LoginPage().loginWithInvalid("mustafaKara@hotmail","123456");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        BrowserUtils.waitFor(3);
       Assert.assertTrue(new LoginPage().warningMsgTxt.isDisplayed());
        BrowserUtils.waitFor(3);
        System.out.println("Actual message : " + new LoginPage().warningMsgTxt.getText());
        new LoginPage().warningCloseBtn.click();


    }

//    @When("the user logs in with valid credentials")
//    public void the_user_logs_in_with_valid_credentials() {
//        new LoginPage().loginWithValid();
//        BrowserUtils.waitFor(2);
//    }

    @Given("the user should not be able to login with blank {string}")
    public void the_user_should_not_be_able_to_login_with_blank(String inputBox) {
        switch (inputBox){
            case "email and password":
                new LoginPage().loginWithInvalid("","");
                BrowserUtils.waitFor(3);
                new LoginPage().SignInBtn.click();
                break;
            case "email":
                new LoginPage().loginWithInvalid("", "123456");
                BrowserUtils.waitFor(3);

                break;
            case "password":
                new LoginPage().loginWithInvalid("mustafakara@hotmail", "");
                BrowserUtils.waitFor(3);

                break;
        }
    }

    @Then("Required field message should be displayed under {string} textBox")
    public void required_field_message_should_be_displayed_under_textBox(String inputBox) {
        {
            switch (inputBox){
                case "username":
                    String expectedMessage = "Please fill out this field.";
                    String actualMessage = new LoginPage().EmailRequired.getAttribute("Requiredfield");
                    System.out.println("actual message = " + actualMessage);
                    Assert.assertEquals(expectedMessage,actualMessage);
                    BrowserUtils.waitFor(3);
                    break;

                case "password":
                    expectedMessage = "Please fill out this field.";
                    actualMessage = new LoginPage().PassRequired.getAttribute("Requiredfield");
                    System.out.println("actual message = " + actualMessage);
                    Assert.assertEquals(expectedMessage,actualMessage);
                    BrowserUtils.waitFor(3);
                    break;
            }
        }
    }


}
