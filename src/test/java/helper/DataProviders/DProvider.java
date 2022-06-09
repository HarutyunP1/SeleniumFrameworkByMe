package helper.DataProviders;

import org.testng.annotations.DataProvider;

public class DProvider {


    @DataProvider(name = "incorrect-usernames-passwords")
    public Object[][] incorrectUsernamePassword() {
        return new Object[][]{
                {"harut.k.petrosyan@gmail.com",""},
                {"harut.k.petrosyan@gmail.com","test"},
                {"","JOker888!@#$%123"},
                {"harut.k.petrosyan@mail.com","JOker888!@#$%123"},
                {"test","JOker888!@#$%123"},

        };


    }
}
