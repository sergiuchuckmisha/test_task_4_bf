package pageObjects.voting;

import pageObjects.voting.pageElements.iSignConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/ballot when confirming sign
 * pageObject pattern is implemented
 */
public class SignConfirmationPopUpPage implements iSignConfirmationPopUp {

    //this method should not be called
    @Deprecated
    @Override
    public String getUrl() {
        return "null";
    }
}
