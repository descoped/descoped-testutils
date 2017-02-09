package io.descoped.testutils.junit4.runner;

import io.descoped.container.module.DescopedContainer;
import io.descoped.container.module.DescopedPrimitive;
import io.descoped.container.module.factory.DefaultInstanceFactory;
import io.descoped.container.module.factory.InstanceFactory;
import io.descoped.container.module.spi.SpiInstanceFactory;
import io.descoped.logger.logback.handler.LogbackBridgeHandler;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

/**
 * Created by oranheim on 09/02/2017.
 */
public class DescopedTestRunner extends BlockJUnit4ClassRunner {

    private static Logger log = LoggerFactory.getLogger(DescopedTestRunner.class);
    private final InstanceFactory<DescopedPrimitive> factory;
    private final DescopedContainer container;

    public DescopedTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
        LogbackBridgeHandler.installJavaUtilLoggerBridgeHandler(Level.CONFIG);
        factory = DefaultInstanceFactory.get(SpiInstanceFactory.class);
        container = new DescopedContainer<>(factory);
    }

    private Class<?> resolveBeanProviderClass() {
        try {
            return Class.forName("org.apache.deltaspike.core.api.provider.BeanProvider");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private void injectFieldsForTestClassIfDeltaSpikeBeanProviderIsPresent(Object instance) {
        try {
            Class<?> beanProviderClass = resolveBeanProviderClass();
            if (beanProviderClass != null) {
                Method staticInjectFieldsMethod = beanProviderClass.getDeclaredMethod("injectFields", new Class[]{Object.class});

                staticInjectFieldsMethod.invoke(getTestClass(), new Object[]{instance});
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        }
    }

    @Override
    protected Object createTest() throws Exception {
        Object instance = super.createTest();
        injectFieldsForTestClassIfDeltaSpikeBeanProviderIsPresent(instance);
        return instance;
    }

    protected void startSpiContainer() {
        container.start();
    }

    protected void stopSpiContainer() {
        container.stop();
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            startSpiContainer();
            super.run(notifier);
        } finally {
            stopSpiContainer();
        }
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        log.trace("Invoke {}.{}", getTestClass().getName(), method.getName());
        super.runChild(method, notifier);
        log.trace("Done with {}.{}", getTestClass().getName(), method.getName());
    }
}
