package tests;

import models.Board;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{

@BeforeMethod
public void  preConditions(){
    app.getUser().initLogin();
    app.getUser().fillLoginForm(User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build());
    app.getUser().submitLogin();
}
    @Test
    public void boardCreation1() throws InterruptedException {

        Board board = Board.builder().title("testQA32").build();
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test
    public void boardCreation2() throws InterruptedException {

        Board board = Board.builder().title("testQA32").build();

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
    }

}
