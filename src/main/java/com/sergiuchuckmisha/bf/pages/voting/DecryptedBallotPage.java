package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IBottomMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.INavigateToUrl;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ITopMenu;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/decrypted
 * pageObject pattern is implemented
 */
public class DecryptedBallotPage implements IPage, INavigateToUrl, ITopMenu, IBottomMenu {

    @Inject private DecryptConfirmationPopUpPage decryptConfirmationPopUpPage;

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

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        decryptConfirmationPopUpPage.defaultNavigateTo();
        decryptConfirmationPopUpPage.pressDecryptBallotConfirmationPopUpButton();
        return isOnPage();
    }
}
