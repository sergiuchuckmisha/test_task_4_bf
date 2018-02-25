package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe name of Decrypted Ballot pages (this name is right under the top menu) in order to get rid of code duplication
 * for example: for page https://exonum.com/demo/voting/#/elections/decrypted this name is 'Full Ballot Encryption Details'
 * pageObject pattern is implemented
 */
public interface IDecryptedBallotSubPageName {

    default String getDecryptedBallotSubPageName(){
        return DriverHelper.getText(By.cssSelector("div.ng-scope > div.app-content-header.ng-scope > span"));
    }

}
