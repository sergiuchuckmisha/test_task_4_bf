package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

public interface ITopMenu {
    String getTopMenuName();

    default boolean isTopMenuNamePresent(){
        return DriverHelper.isElementPresent(
                        By.xpath(String.format(".//div[%s]/span[@class='ng-binding' and text()='%s']",
                                wrapClassContainsForPath("toolbar-title"),
                                getTopMenuName())));
    }

    default void pressTopMenuBackArrow(){
        DriverHelper.click(By.cssSelector("div.toolbar-return-button[ng-show='backState']"));
    }

    default boolean isTopMenuBackArrowVisible(){
        return DriverHelper.findElement(By.cssSelector("div.toolbar-return-button.pull-left[ng-show='backState']")).isDisplayed();

    }

    default void pressTopMenuHelp(){
        DriverHelper.click(By.xpath(String.format(".//div[%s and %s and text()='HELP']",
                wrapClassContainsForPath("toolbar-help-button"),
                wrapClassContainsForPath("pull-right")
        )));
    }
}
