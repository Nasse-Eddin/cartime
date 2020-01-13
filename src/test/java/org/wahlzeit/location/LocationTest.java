package org.wahlzeit.location;

import org.junit.Test;

import org.wahlzeit.model.coordinate.CartesianCoordinate;
import org.wahlzeit.model.coordinate.CoordinateException;
import org.wahlzeit.model.coordinate.ICoordinate;
import org.wahlzeit.model.coordinate.SphericalCoordinate;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void testGetCoordinate() throws CoordinateException {
        Location location = new Location(CartesianCoordinate.getCoordinate(0, 1, 2));
        ICoordinate locationCoordinate = location.getCoordinate();
        assertEquals(locationCoordinate, CartesianCoordinate.getCoordinate(0, 1, 2));
        CartesianCoordinate coor = CartesianCoordinate.getCoordinate(0, 1, 2);
        assertNotEquals(locationCoordinate, CartesianCoordinate.getCoordinate(99, 99, 99));
        assertNotEquals(locationCoordinate, SphericalCoordinate.getCoordinate(0, 1, 2));

    }

    @Test
    public void testCoordinateValue() throws CoordinateException {
        CartesianCoordinate coor = CartesianCoordinate.getCoordinate(0, 1, 2);
        System.out.println(coor.getY());
        assertEquals(0, Double.compare(coor.getY(), 1));
        assertNotEquals(0, Double.compare(coor.getY(), 55));
    }

    @Test
    public void testEquals() throws CoordinateException {
        Location location = new Location(CartesianCoordinate.getCoordinate(0, 1, 2));
        assertTrue(location.equals(CartesianCoordinate.getCoordinate(0, 1, 2)));
    }
}
