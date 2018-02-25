package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import selenium.utils.DriverHelper;

import static selenium.utils.DriverHelper.wrapClassContainsForxPath;

/**idea is to describe 3 color buttons on UnsignedBallotPage and reuse this interface in actions*/
public interface IUnsignedBallotPageDiscardDecryptSignButtons {

    default void discardButtonClick(){
        DriverHelper.click(
                new ByChained(
                    By.cssSelector("div.button-group"),
                    By.xpath(String.format("./div[%s and %s and text()='DISCARD']",
                            wrapClassContainsForxPath("button"),
                            wrapClassContainsForxPath("button-red")
                            ))
                ));
    }

    default void decryptButtonClick(){
        DriverHelper.click(
                new ByChained(
                        By.cssSelector("div.button-group"),
                        By.xpath(String.format("./div[%s and %s and text()='DECRYPT']",
                                wrapClassContainsForxPath("button"),
                                wrapClassContainsForxPath("button-orange")
                        ))
                ));
    }

    default void signButtonClick(){
        DriverHelper.click(
                new ByChained(
                        By.cssSelector("div.button-group"),
                        By.xpath(String.format("./div[%s and %s and text()='SIGN']",
                                wrapClassContainsForxPath("button"),
                                wrapClassContainsForxPath("button-green")
                        ))
                ));
    }
}
