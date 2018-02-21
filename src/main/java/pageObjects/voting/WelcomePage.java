package pageObjects.voting;

import org.openqa.selenium.By;
import pageObjects.iPage;
import pageObjects.voting.pageElements.iVoteInElectionButton;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/welcome
 * pageObject pattern is implemented
 */
public class WelcomePage implements iPage, iVoteInElectionButton {

    private static By headerLocator = By.xpath("//div[@class='app-header' and text()='e-Voting']");
    private static By monitorElectionProcessButtonLocator = By.xpath("//div[@class='button' and text()='Monitor election process']");

    @Override
    public boolean isOnPage() {
        return DriverHelper.isElementPresent(headerLocator);
    }

    public void pressMonitorElectionProcess(){
        DriverHelper.click(monitorElectionProcessButtonLocator);
    }
}
