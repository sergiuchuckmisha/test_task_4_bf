package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

/**idea is to describe 3 color buttons on UnsignedBallotPage and reuse this interface in actions*/
public interface IUnsignedBallotPageDiscardDecryptSignButtons {

    default void discardButtonClick(){
        DriverHelper.click(
                new ByChained(
                    By.cssSelector("div.button-group"),
                    By.xpath(String.format("./div[%s and %s and text()='DISCARD']",
                            wrapClassContainsForPath("button"),
                            wrapClassContainsForPath("button-red")
                            ))
                ));
    }

    default void decryptButtonClick(){
        DriverHelper.click(
                new ByChained(
                        By.cssSelector("div.button-group"),
                        By.xpath(String.format("./div[%s and %s and text()='DECRYPT']",
                                wrapClassContainsForPath("button"),
                                wrapClassContainsForPath("button-orange")
                        ))
                ));
    }

    default void signButtonClick(){
        DriverHelper.click(
                new ByChained(
                        By.cssSelector("div.button-group"),
                        By.xpath(String.format("./div[%s and %s and text()='SIGN']",
                                wrapClassContainsForPath("button"),
                                wrapClassContainsForPath("button-green")
                        ))
                ));
    }
}
