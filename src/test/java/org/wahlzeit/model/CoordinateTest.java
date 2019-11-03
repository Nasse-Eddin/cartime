package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.wahlzeit.model.Coordinate;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CoordinateTest  {
    @Test
    public void getDistanceBetweenTheEqualsCoordinates() {
        Coordinate coordinate1 = new Coordinate(0, 0, 0);
        Coordinate coordinate2 = new Coordinate(0, 0, 0);
        assert (coordinate1.getDistance(coordinate2) == 0);

    }

    @Test

    public void getDistanceBetweenNonEqualCoordinates() {
        Coordinate coordinate1 = new Coordinate(0, 0, 0);
        Coordinate coordinate2 = new Coordinate(1, 1, 1);
        assertNotEquals(coordinate1.getDistance(coordinate2), 0);

    }

    @Test
    public void isEqual() {
        Coordinate coordinate1 = new Coordinate(0, 0, 0);
        Coordinate coordinate2 = new Coordinate(0, 0, 0);
        assertTrue(coordinate1.isEqual(coordinate2));
    }

    @Test
    public void testEquals() {
        Coordinate coordinate1 = new Coordinate(0, 0, 0);
        Coordinate coordinate2 = new Coordinate(0, 0, 0);
        assertTrue(coordinate1.isEqual(coordinate2));
    }
}
