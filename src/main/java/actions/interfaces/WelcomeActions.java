package actions.interfaces;

import org.openqa.selenium.By;
import pageObjects.iPage;
import pageObjects.voting.pageElements.HasUrl;
import pageObjects.voting.pageElements.NavigateTo;
import pageObjects.voting.pageElements.iVoteInElectionButton;
import selenium.utils.DriverHelper;

/**
 * describe actions possible on Welcome page
 */
public class WelcomeActions implements iPage, HasUrl, NavigateTo, iVoteInElectionButton {

    private static final By headerLocator = By.xpath("//div[@class='app-header' and text()='e-Voting']");


    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/welcome";
    }


    @Override
    public boolean isOnPage() {
        return DriverHelper.isElementPresent(headerLocator);
    }

    public void pressMonitorElectionProcess(){
        DriverHelper.click(By.xpath("//div[@class='button' and text()='Monitor election process']"));
    }
}
