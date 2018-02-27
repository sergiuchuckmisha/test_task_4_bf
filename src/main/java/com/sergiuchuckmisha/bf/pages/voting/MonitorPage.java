package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/monitor
 * pageObject pattern is implemented
 */
public class MonitorPage implements IPage, INavigateToUrl, ITopMenu, IBottomMenu, ICheckboxTable {

    @Inject
    private WelcomePage welcomePage;

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/monitor";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Monitor election";
    }

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        welcomePage.defaultNavigateTo();
        welcomePage.pressMonitorElectionProcess();
        return isOnPage();
    }
}
