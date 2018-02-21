package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * idea is to represent confirmation pop-up  which appears after voting for somebody
 */
public interface iVoteConfirmationPopUp extends iPage{

    By yesButtonLocator = By.xpath("//div[@class='button button-red' and @ng-click='submitCandidate()' and text() = 'YES']");
    By cancelButtonLocator = By.xpath("//div[@class='button' and @data-dismiss='modal' and text() = 'CANCEL']");
    By headerLocator = By.xpath("//div[@class='confirm-choise-block-title' and contains(text(), 'Are you sure you want to prepare')]");

    default void pressVoteConfirmationPopUpYesButton() {
        DriverHelper.click(yesButtonLocator);
    }

    default void pressVoteConfirmationPopUpCancelButton() {
        DriverHelper.click(cancelButtonLocator);
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(headerLocator);
    }
}
