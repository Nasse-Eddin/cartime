package org.wahlzeit.location;

import org.wahlzeit.model.coordinate.CoordinateException;
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
            try {
                return coordinate.isEqual((ICoordinate) object);
            } catch (CoordinateException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
