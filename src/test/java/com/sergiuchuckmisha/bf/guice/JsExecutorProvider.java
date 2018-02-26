package com.sergiuchuckmisha.bf.guice;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.inject.Provider;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverManager;

import javax.inject.Inject;

/**class is responsible for pages creating and injecting*/
public class JsExecutorProvider implements Provider<JavaScriptExecutor> {

    WebDriverManager webDriverManager;

    @Inject
    public JsExecutorProvider(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @Override
    public JavaScriptExecutor get() {
        return ((JavaScriptExecutor) webDriverManager.getDriver());
    }
}
