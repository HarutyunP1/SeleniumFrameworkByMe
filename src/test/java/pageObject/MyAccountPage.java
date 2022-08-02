package pageObject;

import helper.browserConfiguration.config.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage<MyAccountPage> {
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "[name='login'][type='submit']")
    private WebElement loginButton;
    @FindBy(id = "menu-item-50")
    private WebElement myAccountMenuItem;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void load() {
        driver.get(PropertyReader.getUrl("myAccountPage"));
        log.info("browser is opening " + PropertyReader.getUrl("myAccountPage") + " this url");
    }

    @Override
    public void isLoaded() throws Error {
        log.info("page is Loaded");

    }

    @Step("this is our fill username step {0} ...STEP")
    public void fillInUsername(String username) {
        usernameField.sendKeys(username);
    }

    @Step("this is our fill password step {1}...STEP")
    public void fillInPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        //loginButton.click();
        //actions.performClickAction(loginButton);
        javaScriptHelper.clickElement(loginButton);
    }

    public boolean isPresentMyAccountMenuItem() {
        return myAccountMenuItem.isDisplayed();
    }


}
