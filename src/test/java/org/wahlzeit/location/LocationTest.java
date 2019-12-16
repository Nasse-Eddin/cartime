package org.wahlzeit.location;

import org.junit.Test;
import org.wahlzeit.model.coordinate.CartesianCoordinate;
import org.wahlzeit.model.coordinate.CoordinateException;
import org.wahlzeit.model.coordinate.ICoordinate;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void testGetCoordinate() throws CoordinateException {
        Location location = new Location(CartesianCoordinate.getCoordinate(0, 1, 2));
        ICoordinate locationCoordinate = location.getCoordinate();
        assertEquals(locationCoordinate, CartesianCoordinate.getCoordinate(0, 1, 2));
        assertNotEquals(locationCoordinate, CartesianCoordinate.getCoordinate(99, 99, 99));
    }

    @Test
    public void testEquals() throws CoordinateException {
        Location location = new Location(CartesianCoordinate.getCoordinate(0, 1, 2));
        assertTrue(location.equals(CartesianCoordinate.getCoordinate(0, 1, 2)));
    }
}
