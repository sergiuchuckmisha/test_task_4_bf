package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

import static selenium.utils.DriverHelper.wrapClassContainsForxPath;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe 'VOTE IN ELECTION' button on election pages in order to get rid of code duplication
 * pageObject pattern is implemented
 */
public interface IVoteInElectionButton {

    default void pressVoteInElectionButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and text()='VOTE IN ELECTION']",
                wrapClassContainsForxPath("button"),
                wrapClassContainsForxPath("button-red")
        )));
    }

}
