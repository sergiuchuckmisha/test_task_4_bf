package pageObjects.voting;

import org.openqa.selenium.By;
import pageObjects.IPage;
import pageObjects.voting.pageElements.INavigateTo;
import pageObjects.voting.pageElements.IBottomMenu;
import pageObjects.voting.pageElements.ITopMenu;
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
public class DecryptedBallotPage implements IPage, INavigateTo, ITopMenu, IBottomMenu {

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
        //method should not be used because TopMenuBackArrow is absent on DecryptedBallotPage
    }

    public void pressReturnButton(){
        DriverHelper.click(By.xpath("//div[@class='button button-link' and @ng-click='electionWizardReset()' and text() = 'RETURN']"));
    }

    public void pressTallyingAuthoritiesAggregatePublicKey(){
        DriverHelper.click(By.xpath("//td[text() = 'Tallying authorities aggregate public key']"));
    }

    public void pressCandidateOptionSelectedAndEncryptionRandomness(){
        DriverHelper.click(By.xpath("//td[text() = 'Candidate option selected and encryption randomness']"));
    }

    public void pressEncryptedBallot(){
        DriverHelper.click(By.xpath("//td[text() = 'Encrypted ballot']"));
    }

    public void pressBallotSHA256Hash(){
        DriverHelper.click(By.xpath("//td[text() = 'Ballot SHA-256 hash']"));
    }

    public void press3WordMemoByBIPMnemonicCodeAlgorithm(){
        DriverHelper.click(By.xpath("//td[contains(text(), '3-word memo by BIP 0039 Mnemonic')]"));
    }
}
