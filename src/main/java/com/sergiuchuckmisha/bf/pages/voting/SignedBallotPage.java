package com.sergiuchuckmisha.bf.pages.voting;

import org.openqa.selenium.By;
import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.INavigateToUrl;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.IBottomMenu;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ITopMenu;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/signed
 * pageObject pattern is implemented
 */
public class SignedBallotPage implements IPage, INavigateToUrl, ITopMenu, IBottomMenu {

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
