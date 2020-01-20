package org.wahlzeit.model.Car;

import org.wahlzeit.services.DataObject;

import java.util.UUID;

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
        this.type = type;
    }

    public boolean isSubType(CarType type) {
        return this.type.equals(type);
    }

}
