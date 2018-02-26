package com.sergiuchuckmisha.bf.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.testng.IModuleFactory;
import org.testng.ITestContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.google.inject.util.Modules.override;


/**
 * class is responsible for pages creating and injecting
 */
public class TestModuleFactory implements IModuleFactory {

    @Override
    public Module createModule(ITestContext context, Class<?> testClass) {

        return getModule();
    }

    // Used in ListenerFactory to inject guice dependencies to testng listeners
    public static Injector getInjector() {
        return Guice.createInjector(getModule());
    }

    private static Module getModule() {
        return new PagesModule();
    }

    private static Module getModule2() {

       // Module defaultModule = new PagesModule();
        Module defaultModule = override(new PagesModule()).with(new PagesModule2());  //TODO refactor
        Module customModule = getCustomModule();

        return customModule != null
                ? Modules.override(defaultModule).with(customModule)
                : defaultModule;
    }

    /**
     * Create module from guice.module system property
     * @return null if guice.module was not defined
     */
    @SuppressWarnings("ConfusingArgumentToVarargsMethod")
    private static Module getCustomModule() {


        String clazz = System.getProperty("guice.module");
        if (clazz == null) return null;
        try {
            Class<?> myClass = Class.forName(clazz);
            Constructor<?> constructor = myClass.getConstructor();
            Object module = constructor.newInstance();
            if (!(module instanceof Module))
                throw new RuntimeException(String.format("Class %s must implement %s interface.",
                        clazz, Module.class.getCanonicalName()));
            return (Module) module;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(String.format("Cannot instantiate module [%s]", clazz), e);
        }
    }
}
