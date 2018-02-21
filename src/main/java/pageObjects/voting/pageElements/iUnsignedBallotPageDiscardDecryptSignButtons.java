package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

/**idea is to describe 3 color buttons on UnsignedBallotPage and reuse this interface in actions*/
public interface iUnsignedBallotPageDiscardDecryptSignButtons {

    default void discardButtonClick(){
        DriverHelper.click(By.xpath("//div[@class='button-group']/div[@class='button button-red' and text()='DISCARD']"));
    }

    default void decryptButtonClick(){
        DriverHelper.click(By.xpath("//div[@class='button-group']/div[@class='button button-orange' and text()='DECRYPT']"));
    }

    default void signButtonClick(){
        DriverHelper.click(By.xpath("//div[@class='button-group']/div[@class='button button-green' and text()='SIGN']"));
    }
}
