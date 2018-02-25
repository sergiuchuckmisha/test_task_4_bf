package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import org.openqa.selenium.By;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

/**
 * idea is to represent confirmation pop-up  which appears after voting for somebody
 */
public interface IVoteConfirmationPopUp extends IPage {
    default void pressVoteConfirmationPopUpYesButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and @ng-click='submitCandidate()' and text() = 'YES']",
                wrapClassContainsForPath("button"),
                wrapClassContainsForPath("button-red")
        )));
    }

    default void pressVoteConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and @data-dismiss='modal' and text() = 'CANCEL']",
                wrapClassContainsForPath("button")
        )));
    }

    @Override
    default boolean isOnPage() {
        return DriverHelper.isElementPresent(By.xpath(String.format("//div[%s and starts-with(text(), 'Are you sure you want to prepare')]",
                wrapClassContainsForPath("confirm-choise-block-title")
        )));
    }
}
