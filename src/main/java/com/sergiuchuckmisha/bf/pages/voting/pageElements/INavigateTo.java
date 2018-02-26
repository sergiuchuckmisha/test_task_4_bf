package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.getDefaultPageLoadWaitTimeoutSeconds;

/**
 * allows navigation (via url or something else)
 */
public interface INavigateTo extends IPage, IHasUrl {

    default void navigateTo() {
        if (!isOnPage()) {
            DriverHelper.navigateToCertainUrl(getUrl());
        }

        DriverHelper.waitUntilExpectedCondition(webDriver -> isOnPage(), getDefaultPageLoadWaitTimeoutSeconds());
        DriverHelper.waitUntilPageIsLoaded();
    }

}
