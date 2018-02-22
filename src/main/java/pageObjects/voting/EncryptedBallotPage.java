package pageObjects.voting;

import org.openqa.selenium.By;
import pageObjects.iPage;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;
import pageObjects.voting.pageElements.iUnsignedBallotPageDiscardDecryptSignButtons;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/decrypted
 * pageObject pattern is implemented
 */
public class EncryptedBallotPage implements iPage, iTopMenu, iBottomMenu, iUnsignedBallotPageDiscardDecryptSignButtons {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/decrypted";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Your Decrypted Ballot";
    }

    @Override
    @Deprecated
    public void pressTopMenuBackArrow(){
        //method should not be used because TopMenuBackArrow is absent on EncryptedBallotPage
    }

    public void pressReturnButton(){
        DriverHelper.click(By.xpath("//div[@class='button button-link' and @ng-click='electionWizardReset()' and text() = 'RETURN']"));
    }
}
