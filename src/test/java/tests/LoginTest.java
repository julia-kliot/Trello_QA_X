package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isLogged()) {
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

    @Test
    public void loginSuccessModel() throws InterruptedException {
        User user = new User().withEmail("juliakliot.jk@gmail.com").withPassword("misha240613");
        app.getUser().initLogin();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        //Thread.sleep(5000);
        app.getUser().isLoggedSuccess();

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

    @Test
    public void loginWithEmptyPassword() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "");
        app.getUser().submitLogin();

        app.getUser().pause(1000);
       // Assert.assertTrue(app.getUser().textErrorWrongPasswordDisplaed().contains("Введите пароль"));
    }

    @Test
    public void loginWithNegPassword() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha");
        app.getUser().submitLogin();

    }
   // @BeforeMethod(alwaysRun = true)
    //public void preCondition(){
        //app.user().initLogin();
        //app.user().fillLoginForm(Auth.builder().email("").password("").build());
       // app.user().submitLogin();
   // }
  // @BeforeMethod(alwaysRun = true)
  // public void preCondition(){
       //if(app.user().isLogginButtonPresent()) {
           //app.user().initLogin();
           //app.user().fillLoginForm(Auth.builder().email("").password("").build());
          // app.user().submitLogin();
      // }


}
