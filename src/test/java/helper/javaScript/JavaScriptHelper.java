package helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;
	
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver){
		this.driver = driver;
		log.info("JavaScriptHelper has been initialised");
	}
	
	/**
	 * This method will execute java script
	 * @param script
	 * @return
	 */
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	/**
	 * This method will execute Java script with multiple arguments
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	/**
	 * This method will scroll till element
	 * @param element
	 */
	public void scrollToElement(WebElement element){
		log.info("scroll to WebElement... "+element);
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	/**
	 * Scroll till element and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		log.info("element is clicked: "+element);
	}
	
	/**
	 * Scroll till element view
	 * @param element
	 */
	public void scrollIntoView(WebElement element){
		log.info("JavascriptExecutor scroll till web element..."+element);
		executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	/**
	 * Scroll till element view and click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		element.click();
		log.info("JavascriptExecutor  element is clicked: by scroll into view and click..."+element);
	}
	
	/**
	 * This method will scroll down vertically
	 */
	public void scrollDownVertically(){
		log.info("JavascriptExecutor scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll up vertically
	 */
	public void scrollUpVertically(){
		log.info("JavascriptExecutor scrolling up vertically...");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll till given pixel (e.g=1500)
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel){
		log.info("JavascriptExecutor scroll down by pixel... "+pixel);
		executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel){
		log.info("JavascriptExecutor scroll up by pixel... "+pixel);
		executeScript("window.scrollBy(0,-"+pixel+")");
	}
	
	/**
	 * This method will zoom screen by 100%
	 */
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method will zoom screen by 60%
	 */
	public void zoomInBy60Percentage(){
		executeScript("document.body.style.zoom='40%'");
	}
	
	/**
	 * This method will click on element
	 * @param element
	 */
	public void clickElement(WebElement element){
		log.info("element is clicked: "+element);
		executeScript("arguments[0].click();", element);
	}
	

}
