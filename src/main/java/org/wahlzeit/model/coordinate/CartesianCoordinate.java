package org.wahlzeit.model.coordinate;


import static java.lang.Math.acos;
import static java.lang.Math.atan2;

/**
 * @author Nasser Eddin Nasser
 * A 3D Cartesia Coordinate.
 */
public final class CartesianCoordinate extends AbstractCoordinate {
    protected final double x;
    protected final double y;
    protected final double z;

    /**
     * constructor
     */
    private CartesianCoordinate(double x, double y, double z) throws CoordinateException {
        this.x = x;
        this.y = y;
        this.z = z;
        assertInvariants();
    }


    /**
     * @param nCoordinate
     * @return true if the coordinate equals to this coordinate
     * else false
     */
    @Override
    public boolean isEqual(ICoordinate nCoordinate) {
        try {
            assertNotNull(nCoordinate);
            assertTyp(nCoordinate);
            CartesianCoordinate cc = nCoordinate.asCartesianCoordinate();
            return (Double.compare(x, cc.x) == 0) && (Double.compare(y, cc.y) == 0) && (Double.compare(z, cc.z) == 0);
        } catch (CoordinateException e) {
            e.printStackTrace();
        }
        return false;
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
    public CartesianCoordinate asCartesianCoordinate() throws CoordinateException {
        return this.getCoordinate(x, y, z);
    }

    public double doGetCartesianDistance(ICoordinate coordinate) throws CoordinateException {
        assertNotNull(coordinate);
        assertTyp(coordinate);
        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate nCoordinate = coordinate.asCartesianCoordinate();
        return Math.sqrt(Math.pow(cartesianCoordinate.getX() - nCoordinate.getX(), 2) +
                Math.pow(cartesianCoordinate.getY() - nCoordinate.getY(), 2) +
                Math.pow(cartesianCoordinate.getZ() - nCoordinate.getZ(), 2));

    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() throws CoordinateException {
//        r = √(x2+y2+z2)
//        phi = atan2(y, x)
//        theta= acos(z/r)
        double radius = Math.pow((Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)), 0.5);
        double phi = atan2(y, x);
        double theta = acos(z / radius);
        return SphericalCoordinate.getCoordinate(phi, theta, radius);
    }


    public double doGetCentralAngle(ICoordinate coordinate) throws CoordinateException {
        assertNotNull(coordinate);
        assertTyp(coordinate);
        return coordinate.asSphericalCoordinate().getCentralAngle(this.asSphericalCoordinate());
    }

    @Override
    public void assertInvariants() throws CoordinateException {
        assertValidDouble(this.x);
        assertValidDouble(this.y);
        assertValidDouble(this.z);
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

    public static CartesianCoordinate getCoordinate(final double x, final double y, final double z) throws CoordinateException {
        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
        int hash = coordinate.hashCode();
        if (!coordinates.contains(hash)) {
            coordinates.put(hash, coordinate);
        }
        return (CartesianCoordinate) coordinates.get(hash);
    }
}

