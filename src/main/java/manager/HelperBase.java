package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void pause( int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String elementGetText(By locator){
        System.out.println(wd.findElement(locator).getText());
        return wd.findElement(locator).getText();
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }


}
