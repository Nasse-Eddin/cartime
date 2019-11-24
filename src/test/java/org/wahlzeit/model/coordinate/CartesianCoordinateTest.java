package org.wahlzeit.model.coordinate;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CartesianCoordinateTest {
    @Test
    public void getDistanceBetweenTheEqualsCoordinates() {
        ICoordinate coordinate1 = new CartesianCoordinate(0, 0, 0);
        ICoordinate coordinate2 = new CartesianCoordinate(0, 0, 0);
        assert (coordinate1.getCartesianDistance(coordinate2) == 0);
    }

    @Test

    public void getDistanceBetweenNonEqualCoordinates() {
        ICoordinate coordinate1 = new CartesianCoordinate(0, 0, 0);
        ICoordinate coordinate2 = new CartesianCoordinate(1, 1, 1);
        assertNotEquals(coordinate1.getCartesianDistance(coordinate2), 0);

    }

    @Test
    public void isEqual() {
        ICoordinate coordinate1 = new CartesianCoordinate(0, 0, 0);
        ICoordinate coordinate2 = new CartesianCoordinate(0, 0, 0);
        assertTrue(coordinate1.equals(coordinate2));
    }

    @Test
    public void testEquals() {
        ICoordinate coordinate1 = new CartesianCoordinate(0, 0, 0);
        ICoordinate coordinate2 = new CartesianCoordinate(0, 0, 0);
        assertTrue(coordinate1.equals(coordinate2));
    }
}
