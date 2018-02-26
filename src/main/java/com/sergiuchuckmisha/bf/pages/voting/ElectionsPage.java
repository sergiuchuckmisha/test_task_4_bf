package com.sergiuchuckmisha.bf.pages.voting;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.INavigateToUrl;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ICheckboxTable;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IBottomMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ITopMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IVoteInElectionButton;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections
 * pageObject pattern is implemented
 */
public class ElectionsPage implements IPage, INavigateToUrl, ITopMenu, IBottomMenu, IVoteInElectionButton, ICheckboxTable {

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
