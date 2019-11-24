package org.wahlzeit.model.coordinate;

public abstract class AbstractCoordinate implements ICoordinate {

    public abstract boolean isEqual(ICoordinate coordinate);

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof ICoordinate) {
            return this.isEqual((ICoordinate) object);
        }
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
}
