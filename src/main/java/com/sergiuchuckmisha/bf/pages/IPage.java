package com.sergiuchuckmisha.bf.pages;

import com.sergiuchuckmisha.bf.pages.voting.pageElements.IDefaultNavigation;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 4:53 PM
 * purpose of this interface is to mark PageObject pattern
 * contains one static method: isOnPage()
 * https://code.google.com/p/selenium/wiki/PageObjects
 */
public interface IPage extends IDefaultNavigation {

    boolean isOnPage();
}
