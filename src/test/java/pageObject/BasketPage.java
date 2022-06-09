package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(css = "[class=\"checkout-button button alt wc-forward\"]")
    private WebElement proceedToCheckout;
    @FindBy(id = "coupon_code")
    private WebElement couponCode;
    @FindBy(css = "[name=\"apply_coupon\"]")
    private WebElement applyCoupon;
    @FindBy(css = ".woocommerce-message")
    private WebElement woocommerceMessage;
    @FindBy(css = ".woocommerce-error")
    private WebElement woocommerceError;
    @FindBy(css = ".cart_item .product-remove a")
    private List<WebElement> removeProduct;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void load() {

    }

    @Override
    public void isLoaded() throws Error {

    }

    public boolean  isNavigateCheckOutPage(){
        proceedToCheckout.click();
        return driver.getCurrentUrl().equals("http://practice.automationtesting.in/checkout/") ;
    }
    public void fillInCoupon(String coupon) {
        couponCode.sendKeys(coupon);
        applyCoupon.click();
    }
    public String getWooCommerceMessage(){
        return woocommerceMessage.getText();
    }
    public String getWooCommerceErrorMessage(){
        return woocommerceError.getText();
    }
    public void removeProduct(){
        try {
            for (int i=0;i<removeProduct.size();i++){
                waitHelper.WaitForElementClickable(removeProduct.get(i),5);
                removeProduct.get(i).click();
            }
        }catch (Exception e){}

    }

}
