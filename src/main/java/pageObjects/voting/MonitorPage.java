package pageObjects.voting;

import pageObjects.iPage;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/monitor
 * pageObject pattern is implemented
 */
public class MonitorPage implements iPage, iTopMenu, iBottomMenu {

    @Override
    public boolean isOnPage() {
        return isNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Monitor election";
    }
}