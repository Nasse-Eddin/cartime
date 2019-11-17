package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.Car.CarPhotoFactoryTest;
import org.wahlzeit.model.Car.CarPhotoManagerTest;
import org.wahlzeit.model.coordinate.CoordinateTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        CarPhotoManagerTest.class,
        CarPhotoFactoryTest.class})
public class ModelTest {
}
