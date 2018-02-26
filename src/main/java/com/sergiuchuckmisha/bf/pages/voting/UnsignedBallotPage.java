package com.sergiuchuckmisha.bf.pages.voting;

import com.sergiuchuckmisha.bf.dataModels.CryptoDetails;
import org.openqa.selenium.By;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.INavigateToUrl;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IBottomMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ITopMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IUnsignedBallotPageDiscardDecryptSignButtons;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/ballot
 * pageObject pattern is implemented
 */
public class UnsignedBallotPage implements IPage, INavigateToUrl, ITopMenu, IBottomMenu, IUnsignedBallotPageDiscardDecryptSignButtons {

    public String getBallotReceipt3WordMemo(){
        return DriverHelper.findElement(By.xpath("//div[text() = 'Ballot reciept 3-word memo']/following-sibling::div")).getText();
    }
    public String getBallotSHA256Hash(){
        return DriverHelper.findElement(By.xpath("//div[text() = 'Ballot  SHA256 hash']/following-sibling::div")).getText();
    }

    public CryptoDetails getCryptoDetails(){
        return new CryptoDetails(getBallotSHA256Hash(), getBallotReceipt3WordMemo());
    }

    @Override
    public String getUrl() {
        return "https://exonum.com/demo/voting/#/elections/ballot";
    }

    @Override
    public boolean isOnPage() {
        return isTopMenuNamePresent();
    }

    @Override
    public String getTopMenuName() {
        return "Your Unsigned Ballot";
    }
}
