package utils;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.BasePage;

public abstract class LoadableComponent<T extends BasePage> {
    protected WebDriver driver;
    protected Logger log = LoggerHelper.getLogger(LoadableComponent.class);

    public LoadableComponent(WebDriver driver) {
        this.driver=driver;
    }

    public T get() {
        log.info("get method is calling ");
        try {
            this.load();
            return (T) this;
        } catch (Error var2) {
            this.load();
            this.isLoaded();
            return (T) this;
        }
    }
    public abstract void load();
    public abstract void isLoaded() throws Error;
}