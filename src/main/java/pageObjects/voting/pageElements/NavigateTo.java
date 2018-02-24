package pageObjects.voting.pageElements;

import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * allows navigation (via url or smth else)
 */
public interface NavigateTo extends iPage, HasUrl {

    default void navigateTo() {
        if (!isOnPage()) {
            DriverHelper.navigateToCertainUrl(getUrl());
        }

        DriverHelper.waitUntilExpectedCondition(webDriver -> isOnPage());
        DriverHelper.waitUntilPageIsLoaded();
    }

}
