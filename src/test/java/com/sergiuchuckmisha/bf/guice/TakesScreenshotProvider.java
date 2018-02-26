package com.sergiuchuckmisha.bf.guice;

import com.google.inject.Provider;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;

import javax.inject.Inject;

/**
 * class is responsible for pages creating and injecting
 */
public class TakesScreenshotProvider implements Provider<TakesScreenshot> {

    WebDriverManager webDriverManager;

    @Inject
    public TakesScreenshotProvider(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @Override
    public TakesScreenshot get() {
        return (TakesScreenshot)(webDriverManager.getActiveDriver());
    }
}
