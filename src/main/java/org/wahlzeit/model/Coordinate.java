package org.wahlzeit.model;

/**
 * @author Nasser Eddin Nasser
 * A 3D Coordinate.
 */
public class Coordinate {
    private double x;
    private double y;
    private double z;

    /**
     * constructor
     */
    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @param nCoordinate
     * @return the distance between two Coordinates
     */
    public double getDistance(Coordinate nCoordinate) {
        return Math.sqrt(powerOfNumberCalculator(x - nCoordinate.x, 2) +
                powerOfNumberCalculator(y - nCoordinate.y, 2) +
                powerOfNumberCalculator(z - nCoordinate.z, 2)
        );
    }

    /**
     * @param nCoordinate
     * @return true if the coordinate equals to this coordinate
     * else false
     */
    public boolean isEqual(Coordinate nCoordinate) {
        return (x == nCoordinate.x) && (y == nCoordinate.y) && (z == nCoordinate.z);
    }

    private double powerOfNumberCalculator(double num, int exponent) {
        if (num == 0 || num == 1 || exponent == 1) return num;
        if (exponent == 0) return 0;
        double res = num;
        for (int i = 0; i < exponent; i++) {
            res *= res;
        }
        return res;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Coordinate) {
            return this.isEqual((Coordinate) object);
        }
        throw new IllegalArgumentException();
    }
}

