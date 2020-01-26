package org.wahlzeit.model.Car;

import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CarType extends DataObject {
    protected Set<CarType> subTypes = new HashSet<CarType>();
    private CarType superCarType;
    private CarBrand carBrand;
    private machineType machineType;

    public CarType(CarBrand carBrand, machineType machineType) {
        this.carBrand = carBrand;
        this.machineType = machineType;
        CarManager.getInstance().getCarType(this);
    }

    public CarType getSuperCarType() {
        return superCarType;
    }

    public Iterator<CarType> getSubCarTypeIterator() {
        return subTypes.iterator();
    }


    public void addSubType(CarType carType) {
        assert (carType != null) : "tried to set null sub car type";
        if (superCarType == null)
            carType.setSuperCarType(this);
        subTypes.add(carType);
    }

    public void setSuperCarType(CarType superCarType) {
        this.superCarType = superCarType;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public machineType getMachineType() {
        return machineType;
    }

    public void setMachineType(machineType machineType) {
        this.machineType = machineType;
    }


    public boolean isSubtype(CarType type) {
        if (superCarType == null) return false;
        return subTypes.contains(type);
    }


}
