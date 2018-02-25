package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

/**idea is to describe 3 color buttons on UnsignedBallotPage and reuse this interface in actions*/
public interface IUnsignedBallotPageDiscardDecryptSignButtons {

    default void discardButtonClick(){
        DriverHelper.click(
                    By.xpath(String.format(".//div[%s]/div[%s and %s and text()='DISCARD']",
                            wrapClassContainsForPath("button-group"),
                            wrapClassContainsForPath("button"),
                            wrapClassContainsForPath("button-red")
                            ))
                );
    }

    default void decryptButtonClick(){
        DriverHelper.click(
                        By.xpath(String.format(".//div[%s]/div[%s and %s and text()='DECRYPT']",
                                wrapClassContainsForPath("button-group"),
                                wrapClassContainsForPath("button"),
                                wrapClassContainsForPath("button-orange")
                        ))
                );
    }

    default void signButtonClick(){
        DriverHelper.click(
                        By.xpath(String.format(".//div[%s]/div[%s and %s and text()='SIGN']",
                                wrapClassContainsForPath("button-group"),
                                wrapClassContainsForPath("button"),
                                wrapClassContainsForPath("button-green")
                        ))
                );
    }
}
