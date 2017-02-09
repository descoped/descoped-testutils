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
public class DescopedTestRunner3Test {

    private static Logger log = LoggerFactory.getLogger(DescopedTestRunner3Test.class);

    @Test
    public void testG() throws Exception {
        log.trace("Hello G!");
    }

    @Test
    public void testH() throws Exception {
        log.trace("Hello H!");
    }

    @Test
    public void testI() throws Exception {
        log.trace("Hello I!");
    }
}
