package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IVoteConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/candidates when confirming vote
 * pageObject pattern is implemented
 */
public class VoteConfirmationPopUpPage implements IVoteConfirmationPopUp {

    @Inject private CandidatesOfElectionPage candidatesOfElectionPage;

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        candidatesOfElectionPage.defaultNavigateTo();
        candidatesOfElectionPage.pressVoteInElectionButton();
        return isOnPage();
    }
}
