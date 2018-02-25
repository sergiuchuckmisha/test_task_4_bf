package pageObjects.voting;

import pageObjects.IPage;
import pageObjects.voting.pageElements.INavigateTo;
import pageObjects.voting.pageElements.ICheckboxTable;
import pageObjects.voting.pageElements.IBottomMenu;
import pageObjects.voting.pageElements.ITopMenu;
import pageObjects.voting.pageElements.IVoteInElectionButton;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections
 * pageObject pattern is implemented
 */
public class ElectionsPage implements IPage, INavigateTo, ITopMenu, IBottomMenu, IVoteInElectionButton, ICheckboxTable {

    @Override
    public String getTopMenuName() {
        return "e-Voting";
    }

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }
}
