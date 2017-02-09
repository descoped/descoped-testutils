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
public class DescopedTestRunnerTest {

    private static Logger log = LoggerFactory.getLogger(DescopedTestRunnerTest.class);

    @Test
    public void testA() throws Exception {
        log.trace("Hello A!");
    }

    @Test
    public void testB() throws Exception {
        log.trace("Hello B!");
    }

    @Test
    public void testC() throws Exception {
        log.trace("Hello C!");
    }
}
