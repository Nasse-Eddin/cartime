package org.wahlzeit.location;

import org.wahlzeit.model.coordinate.ICoordinate;

public class Location {

    private ICoordinate coordinate;

    public Location(ICoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ICoordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ICoordinate) {
            return coordinate.isEqual((ICoordinate) object);
        }
        throw new IllegalArgumentException("The location type is undefined");
    }
}
