package com.sergiuchuckmisha.bf.pages.voting;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.INavigateToUrl;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IVoteInElectionButton;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/welcome
 * pageObject pattern is implemented
 */
public class WelcomePage implements IPage, IVoteInElectionButton, INavigateToUrl {
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
