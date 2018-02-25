package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

public interface ITopMenu {
    String getTopMenuName();

    default boolean isTopMenuNamePresent(){
        return DriverHelper.isElementPresent(
                new ByChained(
                        By.cssSelector("div.toolbar-title"),
                        By.xpath(String.format("./span[@class='ng-binding' and text()='%s']", getTopMenuName()))));
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
