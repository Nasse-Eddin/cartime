package org.wahlzeit.model.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AbstractAdapterTest.class,
        DatastoreAdapterTest.class
})
public class PersistenceTest {
}
