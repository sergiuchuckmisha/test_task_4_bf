package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import pageObjects.iPage;
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

    By electionsButtonLocator = By.xpath("//div[@class='bottom-menu-item-title' and text()='Elections']");
    By monitorButtonLocator = By.xpath("//div[@class='bottom-menu-item-title' and text()='Monitor']");
    By settingsButtonLocator = By.xpath("//div[@class='bottom-menu-item-title' and text()='Settings']");

    static void pressElections(){
        DriverHelper.click(electionsButtonLocator);
    }

    static void pressMonitor(){
        DriverHelper.click(monitorButtonLocator);
    }

    static void pressSettings(){
        DriverHelper.click(settingsButtonLocator);
    }
}
