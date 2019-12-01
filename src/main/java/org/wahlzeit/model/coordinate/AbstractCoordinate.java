package org.wahlzeit.model.coordinate;

public abstract class AbstractCoordinate implements ICoordinate {

    public abstract boolean isEqual(ICoordinate coordinate);

    @Override
    public boolean equals(Object object) {
        assertNotNull(object);
        assertTyp(object);
        return this.isEqual((ICoordinate) object);

    }

    protected void assertNotNull(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Object is Null!");
    }

    protected void assertTyp(Object object) {
        if (!(object instanceof ICoordinate))
            throw new IllegalArgumentException("The coordinate type is undefined");
    }

    public abstract CartesianCoordinate asCartesianCoordinate();


    public double getCartesianDistance(ICoordinate coordinate) {
        return doGetCartesianDistance(coordinate);
    }

    protected abstract double doGetCartesianDistance(ICoordinate coordinate);

    public abstract SphericalCoordinate asSphericalCoordinate();


    public double getCentralAngle(ICoordinate coordinate) {
        return doGetCentralAngle(coordinate);
    }

    public abstract double doGetCentralAngle(ICoordinate coordinate);

    public abstract void assertInvariants();

    protected static void assertValidDouble(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException(" Invalid double value!");
        }

    }

}
