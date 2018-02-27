package com.sergiuchuckmisha.bf.pages.voting;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.pages.voting.pageElements.ISignConfirmationPopUp;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/ballot when confirming sign
 * pageObject pattern is implemented
 */
public class SignConfirmationPopUpPage implements ISignConfirmationPopUp {

    @Inject private UnsignedBallotPage unsignedBallotPage;

    /**method should be used to enter PIN code*/
    public void pressNumber(int i){
        if(i < 0 || i > 9) {
            throw new IllegalArgumentException(String.format("argument expected: number from 0 to 9; provided: %d", i));
        }
        DriverHelper.click(By.xpath(String.format("//div[contains(@class, 'keyboard-button') and text() = '%d']", i)));
    }

    public void enterSomePINCode(){
        pressNumber(1);
        pressNumber(2);
        pressNumber(3);
        pressNumber(4);
    }

    @Override
    public boolean defaultNavigateTo() {
        if (isOnPage()) {
            return true;
        }
        unsignedBallotPage.defaultNavigateTo();
        unsignedBallotPage.signButtonClick();
        return isOnPage();
    }
}
