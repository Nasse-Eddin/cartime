package org.wahlzeit.location;

import org.junit.Test;
import org.wahlzeit.model.Coordinate;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void testGetCoordinate() {
        Location location = new Location(new Coordinate(0, 1, 2));
        Coordinate locationCoordinate = location.getCoordinate();
        assertEquals(locationCoordinate, new Coordinate(0, 1, 2));
        assertNotEquals(locationCoordinate, new Coordinate(99, 99, 99));
    }

    ;

    @Test
    public void testEquals() {
        Location location = new Location(new Coordinate(0, 1, 2));
        assertTrue(location.equals(new Coordinate(0, 1, 2)));
    }
}
