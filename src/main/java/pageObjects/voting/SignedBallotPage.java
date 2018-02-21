package pageObjects.voting;

import pageObjects.iPage;
import pageObjects.voting.pageElements.checkboxTableElements.iCheckboxTable;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/signed
 * pageObject pattern is implemented
 */
public class SignedBallotPage implements iPage, iTopMenu, iBottomMenu {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/signed";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Ballot has been signed";
    }
}
