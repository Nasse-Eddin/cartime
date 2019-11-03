package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ EmailAddressTest.class, LogBuilderTest.class , EmailServiceTestSuite.class})
public class ServicesTest {
}
