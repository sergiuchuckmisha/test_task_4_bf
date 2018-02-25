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
 * https://exonum.com/demo/voting/#/elections/candidates
 * pageObject pattern is implemented
 */
public class CandidatesOfElectionPage implements IPage, INavigateTo, IBottomMenu, ITopMenu,ICheckboxTable, IVoteInElectionButton {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/candidates";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Candidates of Election";
    }
}
