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
        if (myId == null) throw new NullPointerException("Null Photo Id in class:" + this.getClass());
        if (!(myId instanceof PhotoId)) throw new IllegalArgumentException("Undefined Photo Id in class:" + this.getClass());
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
        if (brand == null) throw new NullPointerException("Null brand in class:" + this.getClass());
        if (!(brand instanceof CarBrand)) throw new IllegalArgumentException("Undefined brand in class:" + this.getClass());
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
        if (model == null) throw new NullPointerException("Null model! in class:" + this.getClass());
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
        if (carType == null) throw new NullPointerException("Null Car type! in class:" + this.getClass());
        if (!(carType instanceof CarType)) throw new IllegalArgumentException("Undefined car type in class:" + this.getClass());
        this.carType = carType;
    }

}
