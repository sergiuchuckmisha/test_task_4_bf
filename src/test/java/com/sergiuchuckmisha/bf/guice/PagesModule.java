package com.sergiuchuckmisha.bf.guice;

import com.google.inject.AbstractModule;
import com.google.inject.ProvisionException;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import com.sergiuchuckmisha.bf.config.Config;
import com.sergiuchuckmisha.bf.selenium.browsers.WebDriverFactory;
import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.util.Properties;


/**
 * class is responsible for pages creating and injecting
 */
public class PagesModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(DriverHelper.class, Config.class);//crutch from https://github.com/google/guice/wiki/Injections#static-injections

        bind(TakesScreenshot.class).toProvider(TakesScreenshotProvider.class);

        bind(WebDriverFactory.class).in(Scopes.SINGLETON);

        try {
            Properties props = new Properties();
            props.load(this.getClass().getResourceAsStream("/my.properties"));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            throw new ProvisionException("Error while load properties",  e);
        }
    }
}
