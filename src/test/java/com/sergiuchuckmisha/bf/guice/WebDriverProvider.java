package com.sergiuchuckmisha.bf.guice;

import com.google.inject.Provider;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

/**
 * class is responsible for pages creating and injecting
 */
public class WebDriverProvider implements Provider<WebDriver> {

    WebDriverManager webDriverManager;

    @Inject
    public WebDriverProvider(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @Override
    public WebDriver get() {
        return (webDriverManager.getDriver());
    }
}
