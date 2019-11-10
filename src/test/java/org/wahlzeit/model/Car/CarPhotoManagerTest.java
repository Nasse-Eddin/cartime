package org.wahlzeit.model.Car;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.wahlzeit.model.PhotoId.*;

public class CarPhotoManagerTest {

    @Test
    public void getInstance() {
        assertNotNull(CarPhotoManager.getInstance());
    }

    @Test
    public void getPhotoFromId() {
        CarPhotoManager cm = new CarPhotoManager();
        cm.getInstance();
        assertNull(cm.getPhotoFromId(NULL_ID));

    }

    @Test
    public void getPhoto() {
        CarPhotoManager cm = new CarPhotoManager();
        assertNull(cm.getPhoto(NULL_ID));
    }
}
