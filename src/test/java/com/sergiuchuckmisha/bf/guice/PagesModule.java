package com.sergiuchuckmisha.bf.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.ProvisionException;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import com.sergiuchuckmisha.bf.config.Config;
import com.sergiuchuckmisha.bf.pages.voting.WelcomePage;
import com.sergiuchuckmisha.bf.pages.voting.WelcomePage_2;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverFactory;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.TakesScreenshot;

import javax.inject.Named;
import java.io.IOException;
import java.util.Properties;


/**
 * class is responsible for pages creating and injecting
 */
public class PagesModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(DriverHelper.class, Config.class);//crutcn from https://github.com/google/guice/wiki/Injections#static-injections

        //bind(JavaScriptExecutor.class).toProvider(JsExecutorProvider.class);
        //bind(WebDriver.class).toProvider(WebDriverProvider.class);
        bind(TakesScreenshot.class).toProvider(TakesScreenshotProvider.class);

        bind(WebDriverFactory.class).in(Scopes.SINGLETON);
        bind(WelcomePage.class).to(WelcomePage_2.class);

        bind(String.class).annotatedWith(Names.named("host")).toInstance("exonum.com");
        bind(String.class).annotatedWith(Names.named("path")).toInstance("demo/voting/#/welcome");
        bind(String.class).annotatedWith(Names.named("email")).toProvider(EMailProvider.class);
        //bind(String.class).annotatedWith(Names.named("site-url")).toInstance("demo/voting/#/welcome");

        try {
            Properties props = new Properties();
            props.load(this.getClass().getResourceAsStream("/my.properties"));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            throw new ProvisionException("Error while load properties",  e);
        }
    }

    @Provides @Named("site-url")
    private String getUrl(@Named("host") String host, @Named("path") String path) {
        return String.format("http://%s/%s", host, path);
    }

}
