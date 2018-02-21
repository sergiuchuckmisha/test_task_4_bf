package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe bottom menu html elements on pages elections and monitor in order to get rid of code duplication
 * pageObject pattern is implemented
 */
public interface iBottomMenu {

    default void pressBottomMenuElections(){
        DriverHelper.click(By.xpath("//div[@class='bottom-menu-item-title' and text()='Elections']"));
    }

    default void pressBottomMenuMonitor(){
        DriverHelper.click(By.xpath("//div[@class='bottom-menu-item-title' and text()='Monitor']"));
    }

    default void pressBottomMenuSettings(){
        DriverHelper.click(By.xpath("//div[@class='bottom-menu-item-title' and text()='Settings']"));
    }
}
