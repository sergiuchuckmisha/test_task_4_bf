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
 * https://exonum.com/demo/voting/#/elections/candidates
 * pageObject pattern is implemented
 */
public class CandidatesOfElectionPage
        implements IPage, INavigateToUrl, IBottomMenu, ITopMenu,ICheckboxTable, IVoteInElectionButton {

    @Inject private ElectionsPage electionsPage;

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

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        electionsPage.defaultNavigateTo();
        electionsPage.pressVoteInElectionButton();
        return isOnPage();
    }
}
