package pageObjects.voting;

import org.openqa.selenium.By;
import pageObjects.iPage;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/ballot
 * pageObject pattern is implemented
 */
public class UnsignedBallotPage implements iPage, iTopMenu, iBottomMenu {

    private static By discardButton = By.xpath("//div[@class='button-group']/div[@class='button button-red' and text()='DISCARD']");
    private static By decryptButton = By.xpath("//div[@class='button-group']/div[@class='button button-red' and text()='DECRYPT']");
    private static By signButton = By.xpath("//div[@class='button-group']/div[@class='button button-red' and text()='SIGN']");

    @Override
    public boolean isOnPage() {
        return isNamePresent();
    }

    public void discardButtonClick(){
        DriverHelper.click(discardButton);
    }

    public void decryptButtonClick(){
        DriverHelper.click(decryptButton);
    }

    public void signButtonClick(){
        DriverHelper.click(signButton);
    }

    @Override
    public String getTopMenuName() {
        return "Your Unsigned Ballot";
    }
}
