package org.wahlzeit.model.coordinate;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class CartesianCoordinateTest {
    @Test
    public void getDistanceBetweenTheEqualsCoordinates() throws CoordinateException {
        ICoordinate coordinate1 = CartesianCoordinate.getCoordinate(0, 0, 0);
        ICoordinate coordinate2 = CartesianCoordinate.getCoordinate(0, 0, 0);
        assert (coordinate1.getCartesianDistance(coordinate2) == 0);
    }

    @Test
    public void getDistanceBetweenNonEqualCoordinates() throws CoordinateException {
        ICoordinate coordinate1 = CartesianCoordinate.getCoordinate(0, 0, 0);
        ICoordinate coordinate2 = CartesianCoordinate.getCoordinate(1, 1, 1);
        assertNotEquals(coordinate1.getCartesianDistance(coordinate2), 0);
    }

    @Test
    public void isEqual() throws CoordinateException {
        ICoordinate coordinate1 = CartesianCoordinate.getCoordinate(0, 0, 0);
        ICoordinate coordinate2 = CartesianCoordinate.getCoordinate(0, 0, 0);
        assertTrue(coordinate1.equals(coordinate2));
    }
}
