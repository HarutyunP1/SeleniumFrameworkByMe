package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//ul[@id=\"main-nav\"]//a[contains(text(), 'Shop')]")
    WebElement shopButton;
    @FindBy(css = "div[data-slide-duration=\"0\"] img")
    List<WebElement> slideImages;
    @FindBy(css = "ul[class=\"products\"]")
    List<WebElement> arrivals;
    @FindBy(css = "[class='price']>span")
    List<WebElement> amounts;


    public HomePage(WebDriver driver) {

        super(driver);
    }

    @Override
    public void load() {

    }

    @Override
    public void isLoaded() throws Error {

    }

    public void clickOnShopButton() {
        shopButton.click();
    }

    public void clickOnArrival() {
        int sizeArrivals = arrivals.size();
        arrivals.get((int) (Math.random() * (sizeArrivals))).click();
    }

    public int getSlideLength() {
        return slideImages.size();
    }

    public int getArrivalsLength() {

        return arrivals.size();
    }



    public void clickOnArrival(boolean amountMoreThan450) {
        int sizeArrivals = amounts.size();

        if (amountMoreThan450 == true) {
            for (; true; ) {
                int randomIndex = (int) (Math.random() * (sizeArrivals));
                if (Double.parseDouble(amounts.get(randomIndex).getText().replaceAll("[^0-9.]", "")) >=450){
                    amounts.get(randomIndex).click();
                    break;
                }
            }
        } else {
            for (; true; ) {
                int randomIndex = (int) (Math.random() * (sizeArrivals));
                if (Double.parseDouble(amounts.get(randomIndex).getText().replaceAll("[^0-9.]", "")) < 450){
                    amounts.get(randomIndex).click();
                    break;
                }
            }
        }
    }

}



