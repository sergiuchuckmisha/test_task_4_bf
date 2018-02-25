package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

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

    default void pressBottomMenuElections(){

//        DriverHelper.click(new ByChained(By.cssSelector("div.bottom-menu-item"),
//                By.xpath(String.format("//div[%s and text()='Elections']",
//                        wrapClassContainsForPath("bottom-menu-item-title")))));

        DriverHelper.click(new ByChained(
                By.cssSelector("div.bottom-menu-item"),
                By.xpath(String.format(".//div[%s and text()='Elections']",
                        wrapClassContainsForPath("bottom-menu-item-title")))));
    }

    default void pressBottomMenuMonitor(){
        DriverHelper.click(new ByChained(
                By.cssSelector("div.bottom-menu-item"),
                By.xpath(String.format(".//div[%s and text()='Monitor']",
                        wrapClassContainsForPath("bottom-menu-item-title")))));

    }

    default void pressBottomMenuSettings(){
        DriverHelper.click(new ByChained(
                By.cssSelector("div.bottom-menu-item"),
                By.xpath(String.format(".//div[%s and text()='Settings']",
                        wrapClassContainsForPath("bottom-menu-item-title")))));
    }
}
