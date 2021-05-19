package com.ciceksepeti.pages;

import com.ciceksepeti.utilities.BrowserUtils;
import com.ciceksepeti.utilities.ConfigurationReader;
import com.ciceksepeti.utilities.Driver;
import com.ciceksepeti.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }
        @FindBy(css = "#EmailLogin")
        public WebElement EmailInput;

        @FindBy (css = "#Password")
        public WebElement passwordInput;

        @FindBy (xpath = "//button[@class='btn btn-primary btn-lg pull-right login__btn js-login-button']")
        public WebElement SignInBtn;


        @FindBy (css = ".modal-body")
        public WebElement warningMsgTxt;

        @FindBy (xpath = "//button[@class='btn btn-primary']")
        public WebElement warningCloseBtn;

        @FindBy(xpath = "//span[@class='policy-popup__close icon-close js-policy-close']")
        public WebElement AllowCookies;

        @FindBy (xpath =  "//a[@class='login__forgot-password js-forgot-password']")
        public WebElement ForgotPassBtn;

         @FindBy(xpath = "(//div[@class='form-group'])[5]")
         public WebElement EnterYourEmailText;

         @FindBy (css = "#Mail")
         public WebElement EmailForForgetting;

         @FindBy (xpath = "//button[@class='btn btn-lg btn-primary form-password-recovery__btn js-password-recovery-button']")
         public WebElement SendBtnForForgetting;

         @FindBy (css = "#EmailLogin-error")
        public WebElement EmailRequired;

        @FindBy (css = "#Password-error")
        public WebElement PassRequired;


//    public void loginWithValid() {
//
//        String email = ConfigurationReader.get("email");
//        String password = ConfigurationReader.get("password");
//
//        EmailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        SignInBtn.click();
//    }

        public void loginWithInvalid(String email , String password){

            EmailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            BrowserUtils.waitFor(2);
            AllowCookies.click();
            BrowserUtils.waitFor(3);
            SignInBtn.click();

        }


    }

