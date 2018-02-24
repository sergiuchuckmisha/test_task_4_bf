package pageObjects.voting.pageElements;

import pageObjects.iPage;
import selenium.utils.DriverHelper;

/**
 * allows navigation (via url or smth else)
 */
public interface iNavigateTo extends iPage, iHasUrl {

    default void navigateTo() {
        if (!isOnPage()) {
            DriverHelper.navigateToCertainUrl(getUrl());
        }

        DriverHelper.waitUntilExpectedCondition(webDriver -> isOnPage());
        DriverHelper.waitUntilPageIsLoaded();
    }

}
