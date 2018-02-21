package pageObjects.voting;

import pageObjects.voting.pageElements.iDecryptConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/ballot
 * pageObject pattern is implemented
 */
public class DecryptConfirmationPopUpPage implements iDecryptConfirmationPopUp {

    //this method should not be called
    @Override
    public String getUrl() {
        return "null";
    }
}
