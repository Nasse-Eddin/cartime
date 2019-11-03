package org.wahlzeit.testEnvironmentProvider;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class TestEnvironmentTest {
    static LocalDatastoreServiceTestConfigProvider lds;
    static SysConfigProvider sp;
    static UserServiceProvider usp;
    static UserSessionProvider uSeP;
    static WebFormHandlerProvider wfhp;

    TestEnvironmentTest() {
        lds = new LocalDatastoreServiceTestConfigProvider();
        sp = new SysConfigProvider();
        usp = new UserServiceProvider();
        uSeP = new UserSessionProvider();
        WebFormHandlerProvider wfhp = new WebFormHandlerProvider();
    }

    @BeforeClass
    public static void setUpClass() {

        try {
            sp.before();
            lds.before();
            usp.before();
            uSeP.before();
            wfhp.before();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @AfterClass
    public static void after() {

        try {
            sp.after();
            lds.after();
            usp.after();
            uSeP.after();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
