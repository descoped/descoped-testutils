package io.descoped.testutils.junit4.primitive;

import io.descoped.container.module.DescopedPrimitive;
import io.descoped.container.module.Primitive;

import javax.inject.Singleton;

/**
 * Created by oranheim on 09/02/2017.
 */
@Primitive
@Singleton
public class CdiDummyPrimitive implements DescopedPrimitive {
    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}
