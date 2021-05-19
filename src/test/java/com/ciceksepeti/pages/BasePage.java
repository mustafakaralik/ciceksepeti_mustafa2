package com.ciceksepeti.pages;

import com.ciceksepeti.utilities.BrowserUtils;
import com.ciceksepeti.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public BasePage() { PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(css = "//*[@id = 'appmenu']/*")
    public List<WebElement> menuOptions; //-->List:because we have more than one

    @FindBy(xpath = "//*[@class='mask icon-loading']")      // +++
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(xpath = "//*[@*='user-status-menu-item__header']")    //+++
    public WebElement myUserName;

    @FindBy(css = "[data-id = 'logout']")    //+++
    public WebElement logOutLink;

    @FindBy (xpath = "//div[@class = 'avatardiv avatardiv-shown']")   //+++
    public WebElement userAvatar;




    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        userAvatar.click();
        return myUserName.getText();
    }

    public void logOut(){
        userAvatar.click();
        BrowserUtils.waitFor(3);
        logOutLink.click();
    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     */
    public void navigateToModule(String tab) {
        String tabLocator = "//ul[@id='appmenu']/li/a[@aria-label = '"+ tab +"']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }

    }


}


