package com.sergiuchuckmisha.bf.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


/**
 * class is responsible for pages creating and injecting
 */
@SuppressWarnings("unused")
public class PagesModule3 extends AbstractModule {

    @Override
    protected void configure() {

        bind(String.class).annotatedWith(Names.named("email")).toInstance("eail-3m");

    }

}
