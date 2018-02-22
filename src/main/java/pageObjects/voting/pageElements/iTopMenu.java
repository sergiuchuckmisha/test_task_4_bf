package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import selenium.utils.DriverHelper;

@FunctionalInterface
public interface iTopMenu {
    String getTopMenuName();

    default boolean isTopMenuNamePresent(){
        return DriverHelper.isElementPresent(By.xpath(String.format("//div[@class='toolbar-title']/span[@class='ng-binding' and text()='%s']", getTopMenuName())));
    }

    default void pressTopMenuBackArrow(){
        DriverHelper.click(By.xpath("//div[@class='toolbar-return-button pull-left' and @ng-show='backState']"));
    }

    default boolean isTopMenuBackArrowVisible(){
        return DriverHelper.findElement(By.xpath("//div[@class='toolbar-return-button pull-left' and @ng-show='backState']")).isDisplayed();

    }

    default void pressTopMenuHelp(){
        DriverHelper.click(By.xpath("//div[@class='toolbar-help-button pull-right' and text()='HELP']"));
    }
}
