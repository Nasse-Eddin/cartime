package org.wahlzeit.location;

import org.wahlzeit.model.Coordinate;

public class Location {

    private Coordinate coordinate;

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Coordinate) {
            return coordinate.isEqual((Coordinate) object);
        }
        throw new IllegalArgumentException();
    }
}
