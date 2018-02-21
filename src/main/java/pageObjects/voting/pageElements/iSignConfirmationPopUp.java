package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * idea is to represent confirmation pop-up  which appears when signing your vote
 */
public interface iSignConfirmationPopUp extends iPage{
    default void pressSignConfirmationPopUpYesButton() {
        DriverHelper.click(By.xpath("//div[@class='button button-green' and @ng-click='submitSign()' and text() = 'SIGN BALLOT']"));
    }

    default void pressSignConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath("//div[@class='button button-light' and @data-dismiss='modal' and text() = 'CANCEL']"));
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(By.xpath("//div[@class='decrypt-desc']/p[contains(text(), 'Input your secret PIN2')]"));
    }
}
