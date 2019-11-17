package org.wahlzeit.model.coordinate;

public interface ICoordinate {

    public boolean isEqual(ICoordinate coordinate);

    public CartesianCoordinate asCartesianCoordinate();

    public double getCartesianDistance(ICoordinate coordinate);

    public SphericalCoordinate asSphericalCoordinate();

    public double getCentralAngle(ICoordinate coordinate);

}
