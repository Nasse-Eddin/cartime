package org.wahlzeit.model.Car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

/**
 * A car photo represents a photo to be uploaded.
 * <p>
 * To create a Car Photo following steps needed:
 * CarPhotoFactory: the carPhotos created by CarPhotoFactory
 * * 1- getInstance()  -> which is static and synchronized, it returns the current CarPhotoFactory, if its not created, it creates new CarPhotoFactory
 * * 2- createPhoto() -> which create a Photo without specific photo type
 * <p>
 * CarType:
 * * 1- create new Type or get old type -> Each car photo contains a car, each car contains a car type
 * <p>
 * CarPhoto:
 * * 1- setType(CarType) -> add a car type to a car, the car type is changeable
 * <p>
 * CarPhotoManagement:
 * * 1- getInstance()
 * * 2- addPhoto();
 * ------------------------------
 * <p>
 * 1- delegation of object creation: separate-object
 * 2- Selection of concrete class: by-mapping from carPhotoFactory
 * 3- Configuration of class mapping: in-code
 * 4- Instantiation of concrete class: in-code
 * 5- Initialization of new object: default
 * 6- Building of object structure: default
 */
public class CarPhoto extends Photo {
    private Car car;

    protected CarPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    protected CarPhoto(PhotoId myId) {
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
