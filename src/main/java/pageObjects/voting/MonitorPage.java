package pageObjects.voting;

import pageObjects.IPage;
import pageObjects.voting.pageElements.INavigateTo;
import pageObjects.voting.pageElements.ICheckboxTable;
import pageObjects.voting.pageElements.IBottomMenu;
import pageObjects.voting.pageElements.ITopMenu;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/monitor
 * pageObject pattern is implemented
 */
public class MonitorPage implements IPage, INavigateTo, ITopMenu, IBottomMenu, ICheckboxTable {

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
}
