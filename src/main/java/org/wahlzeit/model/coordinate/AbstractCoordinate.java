package org.wahlzeit.model.coordinate;

public abstract class AbstractCoordinate implements ICoordinate {

    public abstract boolean isEqual(ICoordinate coordinate);

    @Override
    public boolean equals(Object object) {
        try {
            assertNotNull(object);
            assertTyp(object);
        } catch (CoordinateException e) {
            e.printStackTrace();
        }
        return this.isEqual((ICoordinate) object);

    }

    protected void assertNotNull(Object object)throws CoordinateException {
        if (object == null)
            throw new CoordinateException("Object is Null!");
    }

    protected void assertTyp(Object object)throws CoordinateException {
        if (!(object instanceof ICoordinate))
            throw new CoordinateException("The coordinate type is undefined");
    }

    public abstract CartesianCoordinate asCartesianCoordinate() throws CoordinateException;


    public double getCartesianDistance(ICoordinate coordinate)throws CoordinateException {
        return doGetCartesianDistance(coordinate);
    }

    protected abstract double doGetCartesianDistance(ICoordinate coordinate)throws CoordinateException;

    public abstract SphericalCoordinate asSphericalCoordinate() throws CoordinateException;


    public double getCentralAngle(ICoordinate coordinate) throws CoordinateException {
        return doGetCentralAngle(coordinate);
    }

    public abstract double doGetCentralAngle(ICoordinate coordinate) throws CoordinateException;

    public abstract void assertInvariants() throws CoordinateException;

    protected static void assertValidDouble(double x) throws CoordinateException {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new CoordinateException(" Invalid double value! ", AbstractCoordinate.class.getName().toString(), x);
        }

    }

}
