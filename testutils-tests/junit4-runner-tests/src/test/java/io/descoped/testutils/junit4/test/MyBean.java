package io.descoped.testutils.junit4.test;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by oranheim on 09/02/2017.
 */
@ApplicationScoped
public class MyBean {

    String foo = "bar";

    public String getFoo() {
        return foo;
    }
}
