package org.wahlzeit.model.Car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class CarPhoto extends Photo {
    private Car car;

    public CarPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public CarPhoto(PhotoId myId) {
        super(myId);
        if (myId == null) throw new NullPointerException("Null Photo Id in class:" + this.getClass());
        if (!(myId instanceof PhotoId))
            throw new IllegalArgumentException("Undefined Photo Id in class:" + this.getClass());
        id = myId;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
