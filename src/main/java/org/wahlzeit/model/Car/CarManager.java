package org.wahlzeit.model.Car;

import org.wahlzeit.services.ObjectManager;

import java.util.Hashtable;
import java.util.Map;

public class CarManager extends ObjectManager {
    public static final CarManager instance = new CarManager();
    private Map<String, CarType> typesList = new Hashtable<String, CarType>();
    private Map<String, Car> carsList = new Hashtable<String, Car>();

    public static CarManager getInstance() {
        return instance;
    }


    public CarType getCarType(CarType carType) {
        if (typesList.containsKey(carType.hashCode() + "")) {
            return typesList.get(carType.hashCode() + "");
        }
        typesList.put(carType.hashCode() + "", carType);
        return typesList.get(carType.hashCode() + "");
    }

    public Car getCar(Car car) {
        if (carsList.containsKey(car.hashCode() + "")) {
            return carsList.get(car.hashCode() + "");
        }
        carsList.put(car.hashCode() + "", car);
        return carsList.get(car.hashCode() + "");
    }


    public void saveCar(Car car) {
        updateObject(car);
    }

    public void savCarPhotoType(CarType type) {
        updateObject(type);
    }

    public void saveAllTypes() {
        typesList.values().forEach(x -> savCarPhotoType(x));
    }

    public void saveAllCars() {
        carsList.values().forEach(x -> saveCar(x));
    }
}
