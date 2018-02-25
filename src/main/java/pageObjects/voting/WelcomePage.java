package pageObjects.voting;

import pageObjects.voting.pageElements.IHasUrl;
import pageObjects.voting.pageElements.INavigateTo;
import org.openqa.selenium.By;
import pageObjects.IPage;
import pageObjects.voting.pageElements.IVoteInElectionButton;
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
public class WelcomePage implements IPage, IVoteInElectionButton, IHasUrl, INavigateTo {
    private static final By headerLocator =
            By.xpath("//div[@class='app-header' and text()='e-Voting']");

    private static final By monitorElectionProcessButtonLocator =
            By.xpath("//div[@class='button' and text()='Monitor election process']");

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/welcome";
    }

    @Override
    public boolean isOnPage() {
        return DriverHelper.isElementPresent(headerLocator);
    }

    public void pressMonitorElectionProcess() {
        DriverHelper.click(monitorElectionProcessButtonLocator);
    }
}
