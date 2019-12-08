package org.wahlzeit.model.coordinate;

public interface ICoordinate {

    public boolean isEqual(ICoordinate coordinate) throws CoordinateException;;

    public CartesianCoordinate asCartesianCoordinate() throws CoordinateException;

    public double getCartesianDistance(ICoordinate coordinate) throws CoordinateException;;

    public SphericalCoordinate asSphericalCoordinate() throws CoordinateException;

    public double getCentralAngle(ICoordinate coordinate) throws CoordinateException;;

}
