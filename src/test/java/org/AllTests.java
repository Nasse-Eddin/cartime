package org;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.location.HandlersTest;
import org.wahlzeit.location.LocationTest;
import org.wahlzeit.model.ModelTest;
import org.wahlzeit.services.ServicesTest;
import org.wahlzeit.testEnvironmentProvider.TestEnvironmentTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        HandlersTest.class,
        LocationTest.class,
        ModelTest.class,
//        TestEnvironmentTest.class,
        ServicesTest.class
})
public class AllTests {}
