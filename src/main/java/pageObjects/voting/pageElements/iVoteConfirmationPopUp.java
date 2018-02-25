package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.IPage;
import selenium.utils.DriverHelper;

import static selenium.utils.DriverHelper.wrapClassContainsForxPath;

/**
 * idea is to represent confirmation pop-up  which appears after voting for somebody
 */
public interface IVoteConfirmationPopUp extends IPage {
    default void pressVoteConfirmationPopUpYesButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and %s and @ng-click='submitCandidate()' and text() = 'YES']",
                wrapClassContainsForxPath("button"),
                wrapClassContainsForxPath("button-red")
        )));
    }

    default void pressVoteConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath(String.format("//div[%s and @data-dismiss='modal' and text() = 'CANCEL']",
                wrapClassContainsForxPath("button")
        )));
    }

    @Override
    default boolean isOnPage() {
        return DriverHelper.isElementPresent(By.xpath(String.format("//div[%s and starts-with(text(), 'Are you sure you want to prepare')]",
                wrapClassContainsForxPath("confirm-choise-block-title")
        )));
    }
}
