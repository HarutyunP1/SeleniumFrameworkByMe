package testScripts;

import helper.browserConfiguration.config.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.BasketPage;
import pageObject.HomePage;
import pageObject.ProductPage;
import pageObject.ShopPage;

public class HomePageTest extends TestBase {
    private HomePage homePage;
    private ShopPage shopPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    @BeforeClass
    public void openPage() {
        homePage = new HomePage(eventDriver);
        shopPage = new ShopPage(eventDriver);
        productPage=new ProductPage(eventDriver);
        basketPage=new BasketPage(eventDriver);

    }
    @BeforeMethod
    public void navigateHome(){
        getApplicationUrl(PropertyReader.getUrl("applicationUrl"));
        homePage.clickOnShopButton();
        shopPage.clickOnHomeButton();
    }


    @Test(description = "1.Home Page with three Sliders only")
    public void checkHomePageSlidersLength() {
        Assert.assertEquals(homePage.getSlideLength(), 3);
    }

    @Test(description = "2.Home page with three Arrivals only")
    public void checkHomePageArrivalsLength() {
        Assert.assertEquals(homePage.getArrivalsLength(), 3);
    }

    @Test(description = "3. Home page - Images in Arrivals should navigate")
    public void checkImagesNavigation() {
        homePage.clickOnArrival();
        Assert.assertTrue(productPage.isPresentAddToBasket());
    }
    @Test(description = "4. Home page - Description should be presented")
    public void checkImagesDescription() {
        homePage.clickOnArrival();
        Assert.assertFalse(productPage.isPresentDescriptionParagraph());
    }
    @Test(description = "5. Home page - Arrivals-Images-Reviews")
    public void checkAddedReviews() {
        homePage.clickOnArrival();
        productPage.clickOnReviewsTab();
        Assert.assertTrue(productPage.checkAddedComment());
    }
    @Test(description = "6. Home page - Arrivals-Images-Add to Basket")
    public void addBookToBasket() {
        homePage.clickOnArrival();
        productPage.clickOnAddToBasket();
        productPage.clickViewBasket();
        Assert.assertTrue(productPage.isPresentProductItemOnPage());

    }
    @Test(description = "7. Home page - Arrivals-Add to Basket with more books")
    public void AddMoreBooksToBasket(){
        homePage.clickOnArrival();
        Assert.assertTrue(productPage.isAddedMoreBooksThanStock());
    }
    @Test(description = "8. Home-Arrivals-Add to Basket-Items")
    public void AddToBasketItems(){
        homePage.clickOnArrival();
        productPage.clickOnAddToBasket();
        productPage.clickViewBasket();
        Assert.assertTrue(basketPage.isNavigateCheckOutPage());

    }
    @Test(description = "9. Home-Arrivals-Add to Basket-Items-Coupon",enabled = false)
    public void HomeArrivalsAddToBasketItemsCoupon(){
        homePage.clickOnArrival(true);
        productPage.clickOnAddToBasket();
        productPage.clickViewBasket();
        basketPage.fillInCoupon("krishnasakinala");
        Assert.assertEquals(basketPage.getWooCommerceMessage(),"Coupon code applied successfully.");
        basketPage.removeProduct();
    }
    @Test(description = "10. Home-Arrivals-Add to Basket-Items-Coupon value<450")
    public void HomeArrivalsAddToBasketItemsCouponValueLessThan450(){
        homePage.clickOnArrival(false);
        productPage.clickOnAddToBasket();
        productPage.clickViewBasket();
        basketPage.fillInCoupon("krishnasakinala");
        Assert.assertEquals(basketPage.getWooCommerceErrorMessage(),"The minimum spend for this coupon is ₹450.00.");

    }

}
