package org.wahlzeit.model.coordinate;

/**
 * @author Nasser Eddin Nasser
 * A 3D Spherical Coordinate.
 */
public class SphericalCoordinate extends AbstractCoordinate {
    private double radius;
    private double theta;
    private double phi;

    public SphericalCoordinate(double radius, double theta, double phi) throws CoordinateException {
        this.radius = radius;
        this.theta = theta;
        this.phi = phi;
        assertInvariants();
    }

    @Override
    public boolean isEqual(ICoordinate coordinate) {
        try {
            assertNotNull(coordinate);
            assertTyp(coordinate);
            SphericalCoordinate cc = coordinate.asSphericalCoordinate();
            return (Double.compare(phi, cc.getPhi()) == 0) && (Double.compare(theta, cc.getTheta()) == 0) && (Double.compare(radius, cc.getRadius()) == 0);
        } catch (CoordinateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() throws CoordinateException {
//        x = r cos(phi) sin(theta)
//        y = r sin(phi) sin(theta)
//        z = r cos(phi)
        double x = radius * Math.cos(phi) * Math.sin(theta);
        double y = radius * Math.sin(phi) * Math.sin(theta);
        double z = radius * Math.cos(phi);
        return new CartesianCoordinate(x, y, z);
    }

    public double doGetCartesianDistance(ICoordinate coordinate) throws CoordinateException {
        assertNotNull(coordinate);
        assertTyp(coordinate);
        return this.asCartesianCoordinate().getCartesianDistance(coordinate.asCartesianCoordinate());
    }


    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        return this;
    }

    public double doGetCentralAngle(ICoordinate coordinate) throws CoordinateException {
        //https://math.stackexchange.com/questions/2521886/how-to-find-angle-between-2-points-in-3d-space
        assertNotNull(coordinate);
        assertTyp(coordinate);
        CartesianCoordinate myCoordinate = coordinate.asCartesianCoordinate();
        CartesianCoordinate cc = coordinate.asCartesianCoordinate();
        double cosAngle = ((myCoordinate.getX() * cc.getX()) + (myCoordinate.getY() * cc.getY()) + (myCoordinate.getZ() * cc.getX())) / (((Math.pow(Math.pow(myCoordinate.getX(), 2) + Math.pow(myCoordinate.getY(), 2) + Math.pow(myCoordinate.getZ(), 2), 0.5)) * (Math.pow(Math.pow(cc.getX(), 2) + Math.pow(cc.getY(), 2) + Math.pow(cc.getZ(), 2), 0.5))));
        return Math.acos(cosAngle);
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) throws CoordinateException {
        assertValidDouble(theta);
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws CoordinateException {
        assertValidDouble(radius);
        this.radius = radius;
    }

    public double getPhi() throws CoordinateException {
        assertValidDouble(phi);
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    /**
     * Get a hashCode for this set of spherical coordinates.
     * <p>All NaN values have the same hash code.</p>
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        if (isNaN()) { //because i need a boolean return and not an Exception that is why i used a boolean-method instead of assert-method
            return 127;
        }
        return 449 * (79 * Double.hashCode(radius) + Double.hashCode(theta) + Double.hashCode(phi));
    }

    public boolean isNaN() {
        return Double.isNaN(radius) || Double.isNaN(theta) || Double.isNaN(phi);
    }

    @Override
    public void assertInvariants() throws CoordinateException {
        assertValidDouble(this.radius);
        assertValidDouble(this.phi);
        assertValidDouble(this.theta);
    }

}
