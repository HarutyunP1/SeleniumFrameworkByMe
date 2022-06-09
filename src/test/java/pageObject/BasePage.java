package pageObject;

import helper.action.ActionsHelper;
import helper.alert.AlertHelper;
import helper.frame.FrameHelper;
import helper.javaScript.JavaScriptHelper;
import helper.listener.ExtentListener;
import helper.listener.GetScreenShot;
import helper.wait.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.LoadableComponent;

public abstract class BasePage<T extends BasePage> extends LoadableComponent<T> {
    protected ActionsHelper actions;
    protected WaitHelper waitHelper;
    protected AlertHelper alertHelper;
    protected FrameHelper frameHelper;
    protected JavaScriptHelper javaScriptHelper;
    protected GetScreenShot getScreenShot;

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver,this);
        waitHelper=new WaitHelper(super.driver);
        alertHelper=new AlertHelper(super.driver);
        frameHelper=new FrameHelper(super.driver);
        javaScriptHelper=new JavaScriptHelper(super.driver);
        actions=new ActionsHelper(super.driver);
        getScreenShot=new GetScreenShot(super.driver);
    }




}
