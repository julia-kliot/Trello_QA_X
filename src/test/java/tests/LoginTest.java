package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }

    }

    @Test
    public void loginSuccess() throws InterruptedException {

        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha240613");
        app.getUser().submitLogin();
        //Thread.sleep(5000);
        app.getUser().isLoggedSuccess();

        Assert.assertTrue(app.getUser().isLoggedSuccess());


    }
}
