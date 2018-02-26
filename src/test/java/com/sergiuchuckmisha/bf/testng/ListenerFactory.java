package com.sergiuchuckmisha.bf.testng;

import com.sergiuchuckmisha.bf.guice.TestModuleFactory;
import org.testng.ITestNGListener;
import org.testng.ITestNGListenerFactory;

// Used to inject guice into listeners
public class ListenerFactory implements ITestNGListenerFactory, ITestNGListener {

    @Override
    public ITestNGListener createListener(Class<? extends ITestNGListener> listenerClass) {

        if (listenerClass != this.getClass()) {
            try {
                ITestNGListener listener = listenerClass.getConstructor().newInstance();
                TestModuleFactory.getInjector().injectMembers(listener);
                return listener;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
