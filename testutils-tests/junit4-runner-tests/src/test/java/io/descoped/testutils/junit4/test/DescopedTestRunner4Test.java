package io.descoped.testutils.junit4.test;

import io.descoped.testutils.junit4.runner.DescopedTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by oranheim on 09/02/2017.
 */
@RunWith(DescopedTestRunner.class)
public class DescopedTestRunner4Test {

    private static Logger log = LoggerFactory.getLogger(DescopedTestRunner4Test.class);

    @Test
    public void testJ() throws Exception {
        log.trace("Hello J!");
    }

    @Test
    public void testK() throws Exception {
        log.trace("Hello K!");
    }

    @Test
    public void testF() throws Exception {
        log.trace("Hello L!");
    }
}
