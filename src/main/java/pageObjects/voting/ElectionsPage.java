package pageObjects.voting;

import pageObjects.iPage;
import pageObjects.voting.pageElements.NavigateTo;
import pageObjects.voting.pageElements.checkboxTableElements.iCheckboxTable;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;
import pageObjects.voting.pageElements.iVoteInElectionButton;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections
 * pageObject pattern is implemented
 */
public class ElectionsPage implements iPage, NavigateTo, iTopMenu, iBottomMenu, iVoteInElectionButton, iCheckboxTable {

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
