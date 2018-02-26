package com.sergiuchuckmisha.bf.guice;

import com.google.inject.Provider;
import org.apache.commons.lang3.RandomStringUtils;

/**class is responsible for pages creating and injecting*/
public class EMailProvider implements Provider<String> {

    @Override
    public String get() {
        return RandomStringUtils.randomAlphabetic(10)+"@mymail.com";
    }
}
