package org.wahlzeit.model.Car;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

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


}
