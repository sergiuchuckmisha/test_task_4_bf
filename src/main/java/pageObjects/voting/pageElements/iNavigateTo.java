package pageObjects.voting.pageElements;

import pageObjects.IPage;
import selenium.utils.DriverHelper;

/**
 * allows navigation (via url or smth else)
 */
public interface INavigateTo extends IPage, IHasUrl {

    default void navigateTo() {
        if (!isOnPage()) {
            DriverHelper.navigateToCertainUrl(getUrl());
        }

        DriverHelper.waitUntilExpectedCondition(webDriver -> isOnPage());
        DriverHelper.waitUntilPageIsLoaded();
    }

}
