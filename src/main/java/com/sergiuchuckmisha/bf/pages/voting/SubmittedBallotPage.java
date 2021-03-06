package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.dataModels.CryptoDetails;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.*;
import org.openqa.selenium.By;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/submitted
 * pageObject pattern is implemented
 */
public class SubmittedBallotPage implements IPage, INavigateToUrl, ITopMenu, IBottomMenu, ICheckboxTable {

    @Inject private SignedBallotPage signedBallotPage;

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/submitted";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Ballot has been submitted to voting server";
    }

    @Override
    @Deprecated
    public void pressTopMenuBackArrow(){
        //method should not be used because TopMenuBackArrow is absent on SubmittedBallotPage
    }


    public String getBallotReceipt3WordMemo(){
        return DriverHelper.getText(By.xpath("//div[text() = 'Ballot receipt 3-word memo and hash']/following-sibling::div"));
    }

    public String getBallotReceiptHash(){
        return DriverHelper.getText(By.xpath("//div[text() = 'Ballot receipt 3-word memo and hash']/following-sibling::div[2]"));
    }

    public CryptoDetails getCryptoDetails(){
        return new CryptoDetails(getBallotReceiptHash(), getBallotReceipt3WordMemo());
    }

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        signedBallotPage.defaultNavigateTo();
        signedBallotPage.pressSubmitButton();
        return isOnPage();
    }
}
