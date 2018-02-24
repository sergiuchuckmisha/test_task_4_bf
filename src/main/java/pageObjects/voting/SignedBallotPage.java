package pageObjects.voting;

import org.openqa.selenium.By;
import pageObjects.iPage;
import pageObjects.voting.pageElements.iNavigateTo;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/signed
 * pageObject pattern is implemented
 */
public class SignedBallotPage implements iPage, iNavigateTo, iTopMenu, iBottomMenu {

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/signed";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Ballot has been signed";
    }

    @Override
    @Deprecated
    public void pressTopMenuBackArrow(){
        //method should not be used because TopMenuBackArrow is absent on SignedBallotPage
    }

    public void pressDiscardButton(){
        DriverHelper.click(By.xpath("//div[@class='button button-link' and @ng-click='electionWizardReset()' and text() = 'DISCARD BALLOT']"));
    }

    public void pressSubmitButton(){
        DriverHelper.click(By.xpath("//div[@class='button button-green' and text() = 'SUBMIT BALLOT']"));
    }

    public void typeEmail(String email){
        DriverHelper.type(By.xpath("//div[text() = 'E-mail:']/following-sibling::input"), email);
    }
}
