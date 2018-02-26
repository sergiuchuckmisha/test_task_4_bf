package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.getDefaultPageLoadWaitTimeoutSeconds;

/**
 * allows navigation (via url)
 */
public interface INavigateToUrl extends IPage {

    String getUrl();

    default void navigateToUrl() {
        
        if (!isOnPage()) {
            DriverHelper.navigateToCertainUrl(getUrl());
        }

        DriverHelper.waitUntilExpectedCondition(webDriver -> isOnPage(), getDefaultPageLoadWaitTimeoutSeconds());
        DriverHelper.waitUntilPageIsLoaded();
    }

}
