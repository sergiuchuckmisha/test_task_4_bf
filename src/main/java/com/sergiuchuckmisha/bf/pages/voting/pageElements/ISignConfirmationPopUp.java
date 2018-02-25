package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

/**
 * idea is to represent confirmation pop-up  which appears when signing your vote
 */
public interface ISignConfirmationPopUp extends IPage {
    default void pressSignConfirmationPopUpYesButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and @ng-click='submitSign()' and text() = 'SIGN BALLOT']",
                wrapClassContainsForPath("button"),
                wrapClassContainsForPath("button-green")
                )));
    }

    default void pressSignConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and @data-dismiss='modal' and text() = 'CANCEL']",
                wrapClassContainsForPath("button"),
                wrapClassContainsForPath("button-light")
                )));
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(
                        By.xpath(String.format(".//div[%s]/p[starts-with(text(), 'Input your secret PIN2') " +
                                "and contains(text(), 'thus signing your anonymous ballot.')]",
                                wrapClassContainsForPath("decrypt-desc")
                                )));
    }
}
