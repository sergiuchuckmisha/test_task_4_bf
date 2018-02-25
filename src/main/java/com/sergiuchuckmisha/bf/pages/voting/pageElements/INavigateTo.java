package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.DEFAULT_PAGE_LOAD_WAIT_TIMEOUT_SECONDS;

/**
 * allows navigation (via url or smth else)
 */
public interface INavigateTo extends IPage, IHasUrl {

    default void navigateTo() {
        if (!isOnPage()) {
            DriverHelper.navigateToCertainUrl(getUrl());
        }

        DriverHelper.waitUntilExpectedCondition(webDriver -> isOnPage(), DEFAULT_PAGE_LOAD_WAIT_TIMEOUT_SECONDS);
        DriverHelper.waitUntilPageIsLoaded();
    }

}
