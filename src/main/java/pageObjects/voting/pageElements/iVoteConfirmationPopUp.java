package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * idea is to represent confirmation pop-up  which appears after voting for somebody
 */
public interface iVoteConfirmationPopUp extends iPage{
    default void pressVoteConfirmationPopUpYesButton() {
        DriverHelper.click(By.xpath("//div[@class='button button-red' and @ng-click='submitCandidate()' and text() = 'YES']"));
    }

    default void pressVoteConfirmationPopUpCancelButton() {
        DriverHelper.click(By.xpath("//div[@class='button' and @data-dismiss='modal' and text() = 'CANCEL']"));
    }

    @Override
    default boolean isOnPage(){
        return DriverHelper.isElementPresent(By.xpath("//div[@class='confirm-choise-block-title' and contains(text(), 'Are you sure you want to prepare')]"));
    }
}
