package org.wahlzeit.model.coordinate;


import static java.lang.Math.acos;
import static java.lang.Math.atan2;

/**
 * @author Nasser Eddin Nasser
 * A 3D Cartesia Coordinate.
 */
public class CartesianCoordinate implements ICoordinate {
    private double x;
    private double y;
    private double z;

    /**
     * constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * @param nCoordinate
     * @return true if the coordinate equals to this coordinate
     * else false
     */
    @Override
    public boolean isEqual(ICoordinate nCoordinate) {
        CartesianCoordinate cc = nCoordinate.asCartesianCoordinate();
        return (x == cc.x) && (y == cc.y) && (z == cc.z);
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
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(ICoordinate coordinate) {
        CartesianCoordinate nCoordinate = coordinate.asCartesianCoordinate();
        return Math.sqrt(Math.pow(this.getX() - nCoordinate.getX(), 2) +
                Math.pow(this.getY() - nCoordinate.getY(), 2) +
                Math.pow(this.getZ() - nCoordinate.getZ(), 2));
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
//        r = √(x2+y2+z2)
//        phi = atan2(y, x)
//        theta= acos(z/r)
        double radius = Math.pow((Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)), 0.5);
        double phi = atan2(y, x);
        double theta = acos(z / radius);
        return new SphericalCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(ICoordinate coordinate) {
//https://math.stackexchange.com/questions/2521886/how-to-find-angle-between-2-points-in-3d-space
        CartesianCoordinate cc = coordinate.asCartesianCoordinate();
        double cosAngle = ((this.x * cc.getX()) + (this.y * cc.getY()) + (this.z * cc.getX())) / (((Math.pow(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2), 0.5)) * (Math.pow(Math.pow(cc.getX(), 2) + Math.pow(cc.getY(), 2) + Math.pow(cc.getZ(), 2), 0.5))));
        return Math.acos(cosAngle);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ICoordinate) {
            return this.isEqual((ICoordinate) object);
        }
        throw new IllegalArgumentException(" The coordinate type is undefined");
    }

    //    https://stackoverflow.com/questions/9858376/hashcode-for-3d-integer-coordinates-with-high-spatial-coherence
    @Override
    public int hashCode() {
        int hash = 23;
        hash = hash * 31 + (int) x;
        hash = hash * 31 + (int) y;
        hash = hash * 31 + (int) z;
        return hash;
    }
}

