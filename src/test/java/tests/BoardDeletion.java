package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase {
    @BeforeMethod
            public void preCondition2() {
        if (app.getUser().isLoginButtonPresent()) {
            app.getUser().initLogin();
            app.getUser().fillLoginForm(User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build());
            app.getUser().submitLogin();
        }
    }
    @Test
    public void boardDeletion() throws InterruptedException {

        int boardCountBeforeDeletion = app.getBoard().getBoardCount();
        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().openSideBoardMenu();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        int boardCountAfterDeletion = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterDeletion, boardCountBeforeDeletion - 1);
    }

}
