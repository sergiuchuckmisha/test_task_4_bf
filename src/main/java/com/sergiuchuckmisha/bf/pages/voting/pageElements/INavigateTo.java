package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.pages.IPage;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;

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
