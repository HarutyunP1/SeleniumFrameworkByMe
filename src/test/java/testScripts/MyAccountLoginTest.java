package testScripts;

import helper.DataProviders.DProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.MyAccountPage;

public class MyAccountLoginTest extends TestBase {

    private MyAccountPage myAccountPage;

    @BeforeClass
    public void init() {
        myAccountPage = new MyAccountPage(eventDriver);
        myAccountPage.get();
        System.out.println("hi");

    }

    @BeforeMethod
    public void myAccountPage() {
        myAccountPage.clickOnLoginButton();
    }



    @Test(description = "first description")
    public void test_method1() {
        fillInLoginFields("Harut","Petrosyan");
        Assert.assertTrue(false);
    }
//
//    @Test()
//    public void test_method2() {
//    }


    private void fillInLoginFields(String username, String password) {
        if (!username.isEmpty())
            myAccountPage.fillInUsername(username);
        if (!password.isEmpty())
            myAccountPage.fillInPassword(password);
        myAccountPage.clickOnLoginButton();
    }

//    @Test(description = "1-6. Log-in with invalid  username and password.", dataProviderClass = DProvider.class,
//            dataProvider = "incorrect-usernames-passwords")
//    public void loginWithInValidUsernameAndPassword(String username, String password) {
//        fillInLoginFields(username, password);
//    }


}
