package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));

    }
    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        type(By.cssSelector("#password"), password);
    }
    public void fillLoginForm(User user) {
        type(By.cssSelector("#user"), user.getEmail());
        click(By.cssSelector("#login"));
        type(By.cssSelector("#password"), user.getPassword());
    }
    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public boolean isLoggedSuccess(){
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("._2ft40Nx3NZII2i"))));
        return  wd.findElement(By.cssSelector("._2ft40Nx3NZII2i")).isDisplayed();

    }
    public void logOut(){
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));

    }
    public boolean isLogged(){
        return  wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size()>0;
    }
    public String textErrorMessage(){
        return elementGetText(By.cssSelector("#error p"));
    }

    public String textErrorWrongPasswordDisplaed() {

        return elementGetText(By.cssSelector("#password-error"));
    }


    public boolean isLogginButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
  public boolean isLoginButtonPresent(){
        return  isElementPresent(By.cssSelector("[href='/login']"));

  }

}

