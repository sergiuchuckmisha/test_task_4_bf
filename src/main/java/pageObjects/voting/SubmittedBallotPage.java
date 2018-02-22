package pageObjects.voting;

import org.openqa.selenium.By;
import pageObjects.iPage;
import pageObjects.voting.pageElements.checkboxTableElements.iCheckboxTable;
import pageObjects.voting.pageElements.iBottomMenu;
import pageObjects.voting.pageElements.iTopMenu;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://exonum.com/demo/voting/#/elections/submitted
 * pageObject pattern is implemented
 */
public class SubmittedBallotPage implements iPage, iTopMenu, iBottomMenu, iCheckboxTable {

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


    public String getBallotReceipt3WordMemo(){
        return DriverHelper.getText(By.xpath("//div[text() = 'Ballot receipt 3-word memo and hash']/following-sibling::div"));
    }

    public String getBallotReceiptHash(){
        return DriverHelper.getText(By.xpath("//div[text() = 'Ballot receipt 3-word memo and hash']/following-sibling::div[2]"));
    }
}
