package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * idea is to represent confirmation pop-up  which appears after trying to decrypt vote
 */
public interface iDecryptConfirmationPopUp extends iPage{
    default void pressDecryptBallotConfirmationPopUpButton() {
        DriverHelper.click(By.xpath("//div[@class='button button-orange' and @ng-click='submitDecrypt()' and text() = 'DECRYPT BALLOT']"));
    }

    default void pressDecryptConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath("//div[@data-dismiss='modal' and text() = 'CANCEL']"));
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(By.xpath("//div[@class='decrypt-desc']/p[text() = 'Are you sure you want to proceed with decrypting your ballot?']"));
    }
}
