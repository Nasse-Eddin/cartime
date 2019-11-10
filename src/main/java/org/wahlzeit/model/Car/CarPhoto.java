package org.wahlzeit.model.Car;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class CarPhoto extends Photo {

    private CarBrand brand;
    private String model;
    private CarType carType;

    public CarPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public CarPhoto(PhotoId myId) {
        super(myId);
        id = myId;
    }

    /**
     * @MethodType Quere
     */
    public CarBrand getBrand() {
        return brand;
    }

    /**
     * @MethodType Mutation
     */
    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    /**
     * @MethodType Quere
     */
    public String getModel() {
        return model;
    }

    /**
     * @MethodType Mutation
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @MethodType Quere
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * @MethodType Mutation
     */
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

}
