package org.wahlzeit.model.Car;

import org.wahlzeit.services.DataObject;

import java.util.UUID;

 /**
 * Instantiation of car that use to create a car photo.
 * Each car has a type that is changeable and an unique ID that is unchangeable.
 * A car can be directly created from its constructor by adding a type of it, the Car Manager will check if the car already exist or it will add new car to carList "HashTable".
 * By adding a type to car, the Car Manager will check if the type already exist or it will add new type to typesList "HashTable".
 *
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
 * 2- Selection of concrete class: by-mapping in CarManager
 * 3- Configuration of class mapping: in-code
 * 4- Instantiation of concrete class: in-code
 * 5- Initialization of new object: default
 * 6- Building of object structure: default
 */

public class Car extends DataObject {
    private CarType type;
    private CarBrand carBrand;
    private machineType machineType;
    private String carID;

    public Car(CarType carType) {
        this.type = CarManager.getInstance().getCarType(carType);
        CarManager.getInstance().getCar(this);
        carID = UUID.randomUUID().toString();
        ;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = CarManager.getInstance().getCarType(type);
    }

    public boolean isSubType(CarType type) {
        return this.type.equals(type);
    }

}
