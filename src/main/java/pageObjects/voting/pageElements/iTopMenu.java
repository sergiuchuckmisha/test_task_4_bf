package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

public interface iTopMenu {
    By backArrowLocator = By.xpath("//div[@class='toolbar-return-button pull-left' and @ng-show='backState']");
    By helpLocator = By.xpath("//div[@class='toolbar-help-button pull-right' and text()='HELP']");

    String getTopMenuName();

    default boolean isTopMenuNamePresent(){
        return DriverHelper.isElementPresent(By.xpath(String.format("//div[@class='toolbar-title']/span[@class='ng-binding' and text()='%s']", getTopMenuName())));
    }

    default void pressTopMenuBackArrow(){
        DriverHelper.click(backArrowLocator);
    }

    default void pressTopMenuHelp(){
        DriverHelper.click(helpLocator);
    }
}
