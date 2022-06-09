package helper.action;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionsHelper {
    private WebDriver driver;

    private Logger log = LoggerHelper.getLogger(ActionsHelper.class);

    public ActionsHelper(WebDriver driver) {
        this.driver = driver;
        log.info("ActionsHelper has been initialised");
    }
    /**
     * This method will move to element and click
     * @param element
     */
    public void performClickAction(WebElement element){
        Actions action = new Actions(this.driver);
        action.moveToElement(element).click().perform();
        log.info("ActionsHelper perform click action ... "+element);


    }
    /**
     * This method will move to element by index and click
     * @param elements
     * @param  index
     */
    public void performClickActionByIndex(List<WebElement> elements,int index){
        Actions action = new Actions(this.driver);
        WebElement element=elements.get(index);
        action.moveToElement(element).click().perform();
        log.info("ActionsHelper click action by index "+index+ "..."+element);

    }


}
