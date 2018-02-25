package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import pageObjects.IPage;
import selenium.utils.DriverHelper;

import static selenium.utils.DriverHelper.wrapClassContainsForxPath;

/**
 * idea is to represent confirmation pop-up  which appears when signing your vote
 */
public interface ISignConfirmationPopUp extends IPage {
    default void pressSignConfirmationPopUpYesButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and @ng-click='submitSign()' and text() = 'SIGN BALLOT']",
                wrapClassContainsForxPath("button"),
                wrapClassContainsForxPath("button-green")
                )));
    }

    default void pressSignConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and @data-dismiss='modal' and text() = 'CANCEL']",
                wrapClassContainsForxPath("button"),
                wrapClassContainsForxPath("button-light")
                )));
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(
                new ByChained(
                        By.cssSelector("div.decrypt-desc"),
                        By.xpath("./p[starts-with(text(), 'Input your secret PIN2') " +
                                "and contains(text(), 'thus signing your anonymous ballot.')]")));
    }
}
