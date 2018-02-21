package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

public interface iTopMenu {
    By backArrowLocator = By.xpath("//div[@class='toolbar-return-button pull-left' and @ng-show='backState']");
    By helpLocator = By.xpath("//div[@class='toolbar-help-button pull-right' and text()='HELP']");
//    By nameLocator = By.xpath(String.format("//div[@class='toolbar-title']/span[@class='ng-binding' and text()='%s']", getTopMenuName()));

    String getTopMenuName();

    default boolean isNamePresent(){
//        return DriverHelper.isElementPresent(nameLocator);
        return DriverHelper.isElementPresent(By.xpath(String.format("//div[@class='toolbar-title']/span[@class='ng-binding' and text()='%s']", getTopMenuName())));
    }

    static void pressBackArrow(){
        DriverHelper.click(backArrowLocator);
    }

    static void pressHelp(){
        DriverHelper.click(helpLocator);
    }
}
