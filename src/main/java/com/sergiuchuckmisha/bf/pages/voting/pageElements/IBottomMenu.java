package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe bottom menu html elements on com.sergiuchuckmisha.bf.pages elections and monitor
 * in order to get rid of code duplication
 * pageObject pattern is implemented
 */
public interface IBottomMenu {

    default void pressBottomMenuElections() {


        DriverHelper.click(
                By.xpath(String.format(".//div[%s]//div[%s and text()='Elections']",
                        wrapClassContainsForPath("bottom-menu-item"),
                        wrapClassContainsForPath("bottom-menu-item-title")
                )));
    }

    default void pressBottomMenuMonitor() {
        DriverHelper.click(
                By.xpath(String.format(".//div[%s]//div[%s and text()='Monitor']",
                        wrapClassContainsForPath("bottom-menu-item"),
                        wrapClassContainsForPath("bottom-menu-item-title")
                )));

    }

    default void pressBottomMenuSettings() {
        DriverHelper.click(
                By.xpath(String.format(".//div[%s]//div[%s and text()='Settings']",
                        wrapClassContainsForPath("bottom-menu-item"),
                        wrapClassContainsForPath("bottom-menu-item-title")
                )));
    }
}
