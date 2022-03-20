package manager;

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
}
