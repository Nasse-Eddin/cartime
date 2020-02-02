package org.wahlzeit.model.Car;

import org.wahlzeit.services.DataObject;

import java.util.UUID;

/**
 * Instantiation of car that use to create a car photo.
 * Each car has a type that is changeable and an unique ID that is unchangeable.
 * A car can be directly created from its constructor by adding a type of it, the Car Manager will check if the car already exist or it will add new car to carList "HashTable".
 * By adding a type to car, the Car Manager will check if the type already exist or it will add new type to typesList "HashTable".
 * <p>
 * 1- delegation of object creation: separate-object
 * 2- Selection of concrete class: by-mapping in CarManager
 * 3- Configuration of class mapping: in-code
 * 4- Instantiation of concrete class: in-code
 * 5- Initialization of new object: default
 * 6- Building of object structure: default
 * <p>
 * -------
 * CW #14
 * <p>
 * Car with CarType:
 * Collaboration (Type Object), it provides information to all instances of a car type.
 * It binds the Car object(the base object) with the CarType (type)
 * <p>
 * with CarPhoto:
 * Collaboration (client service), it provides main domain functionality.
 * It binds the CarPhoto (client role) with the Car (service)
 * <p>
 * Car with CarManager:
 * Collaboration (manager element), it centralize object management in CarManagement.
 * It binds the Car (element role) with the CarManager (manager role).
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
