package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe 'VOTE IN ELECTION' button on election pages in order to get rid of code duplication
 * pageObject pattern is implemented
 */
public interface iVoteInElectionButton {

    By voteButtonLocator = By.xpath("//div[@class='button button-red' and text()='VOTE IN ELECTION']");

    default void pressVote(){
        DriverHelper.click(voteButtonLocator);
    }
}
