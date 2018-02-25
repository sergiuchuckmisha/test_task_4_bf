package com.sergiuchuckmisha.bf.pages.voting;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.INavigateTo;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ICheckboxTable;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IBottomMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ITopMenu;

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
