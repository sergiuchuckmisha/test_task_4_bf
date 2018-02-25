package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import pageObjects.IPage;
import selenium.utils.DriverHelper;

import static selenium.utils.DriverHelper.wrapClassContainsForxPath;

/**
 * idea is to represent confirmation pop-up  which appears after trying to decrypt vote
 */
public interface IDecryptConfirmationPopUp extends IPage {
    default void pressDecryptBallotConfirmationPopUpButton() {
        DriverHelper.click(By.xpath(
                String.format(".//div[%s and @ng-click='submitDecrypt()' and text() = 'DECRYPT BALLOT']",
                wrapClassContainsForxPath("button button-orange"))));
    }

    default void pressDecryptConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath(".//div[@data-dismiss='modal' and text() = 'CANCEL']"));
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(
                new ByChained(
                        By.cssSelector("div.decrypt-desc"),
                        By.xpath("./p[text() = 'Are you sure you want to proceed with decrypting your ballot?']")));
    }
}
