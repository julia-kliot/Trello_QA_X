package manager;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        click(By.cssSelector("[aria-label='BoardIcon']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id = 'create-board-title-input']"), board.getTitle());
    }
    public  void scrollDowmTheForm(){
        Actions action = new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector("[data-test-id='header-create-menu-popover']"));
        Rectangle rect = container.getRect();
        int x= rect.getX()+20;
        int y= rect.getY()+ rect.getHeight()/2;
        action.moveByOffset(x,y).click().perform();

    }

    public void  submitBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        Thread.sleep(5000);
    }

    public boolean isCreated(){
        WebDriverWait wait= new WebDriverWait(wd,5000);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".list-name-input"))));
        return wd.findElement(By.cssSelector(".list-name-input")).isDisplayed();

    }
    public void returnToHomePage(){
        click(By.cssSelector("._2ft40Nx3NZII2i"));
    }
    public int getBoardCount(){
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size()-1-recentlyViewedBoards();
    }

    public int recentlyViewedBoards(){
        return wd.findElements(By.xpath("//*[contains(@class,'icon-clock')]/../../..//li")).size();

    }
    public void clickOnTheFirstBoard(){
        click(By.cssSelector(".board-tile-details"));
    }
    public void  openSideBoardMenu(){
        click(By.cssSelector(".js-show-sidebar"));
    }

    public void openMore(){
        click(By.cssSelector(".js-open-more"));
    }
    public void  closeBoard() throws InterruptedException {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector("[data-test-id='close-board-delete-board-button']"));
        Thread.sleep(5000);
        click(By.cssSelector("[data-test-id='close-board-delete-board-confirm-button']"));
    }

}