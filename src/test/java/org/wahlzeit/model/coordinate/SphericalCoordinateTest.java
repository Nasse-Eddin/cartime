package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphericalCoordinateTest {
    @Test
    public void getDistanceBetweenTheEqualsCoordinates() throws CoordinateException {
        ICoordinate coordinate1 =  SphericalCoordinate.getCoordinate(0, 0, 0);
        ICoordinate coordinate2 =  SphericalCoordinate.getCoordinate(0, 0, 0);
        assert (coordinate1.getCartesianDistance(coordinate2) == 0);
    }

    @Test

    public void getDistanceBetweenNonEqualCoordinates() throws CoordinateException {
        ICoordinate coordinate1 =  SphericalCoordinate.getCoordinate(0, 0, 0);
        ICoordinate coordinate2 =  SphericalCoordinate.getCoordinate(1, 1, 1);
        assertNotEquals(coordinate1.getCartesianDistance(coordinate2), 0);

    }

    @Test
    public void isEqual() throws CoordinateException {
        ICoordinate coordinate1 =  CartesianCoordinate.getCoordinate(0, 0, 0);
        ICoordinate coordinate2 =  SphericalCoordinate.getCoordinate(0, 0, 0);
        assertTrue(coordinate1.isEqual(coordinate2));
    }

}
