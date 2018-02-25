package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import org.openqa.selenium.By;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to get text values of fields on decrypted ballot com.sergiuchuckmisha.bf.pages
 * for example: for page https://exonum.com/demo/voting/#/elections/hash field with name 'HASH HEXADECIMAL' should contain string with 64 chars
 * expected pattern: 2 following divs: first with name, second with value
 */
public interface IGetTextFromFieldWithCertainName {

    default String getDecryptedBallotSubPageName(String fieldName){
        return DriverHelper.getText(By.xpath(String.format("//div[text() = '%s']/following-sibling::div", fieldName)));
    }

}
