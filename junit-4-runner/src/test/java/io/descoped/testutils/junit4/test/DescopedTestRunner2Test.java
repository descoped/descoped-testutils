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
public class DescopedTestRunner2Test {

    private static Logger log = LoggerFactory.getLogger(DescopedTestRunner2Test.class);

    @Test
    public void testD() throws Exception {
        log.trace("Hello D!");
    }

    @Test
    public void testE() throws Exception {
        log.trace("Hello E!");
    }

    @Test
    public void testF() throws Exception {
        log.trace("Hello F!");
    }
}
