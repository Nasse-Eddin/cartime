package org.wahlzeit.model.Car;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.io.IOException;

import static org.junit.Assert.*;


public class CarPhotoFactoryTest {
    CarPhotoFactory cpf;

    @Before
    public void setUp() {
        cpf = CarPhotoFactory.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(cpf.getInstance());
    }


    @Test
    public void testCreatePhoto() {
        PhotoId id = new PhotoId(555);
        Photo car = new CarPhoto(id);
        assertEquals(cpf.createPhoto(id).getId(), car.getId());
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalSetInstance() {
        CarPhotoFactory.setInstance(new CarPhotoFactory());
        cpf.setInstance(cpf);
    }

    @Test
    public void testCreateCarPhoto() {
        CarPhoto carPhoto = (CarPhoto) cpf.getInstance().createPhoto();
        CarType audiA1 = new CarType(CarBrand.Audi, machineType.Compact);
        Car a1 = new Car(audiA1);
        carPhoto.setCar(a1);
        assertEquals(new CarManager().getCar(a1), a1);
        assertEquals(new CarManager().getCarType(audiA1), audiA1);
        assertNotEquals(new CarManager().getCarType(audiA1), null);
        assertNotEquals(new CarManager().getCarType(audiA1), new CarType(CarBrand.Audi, machineType.Compact));
        assertNotEquals(new CarManager().getCar(a1), new Car(audiA1));
        assertNotEquals(new CarManager().getCar(a1), null);
    }

    @Test
    public void testIsSubtype() {
        CarType audiA1 = new CarType(CarBrand.Audi, machineType.Compact);
        CarType aClass = new CarType(CarBrand.Mercedes_Benz, machineType.Compact);
        Car a1 = new Car(audiA1);
        Car a2 = new Car(audiA1);
        assertTrue(a1.isSubType(audiA1));
        assertTrue(a2.isSubType(audiA1));
        assertFalse(a2.isSubType(aClass));
    }


}
