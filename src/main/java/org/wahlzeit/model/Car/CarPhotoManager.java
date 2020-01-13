package org.wahlzeit.model.Car;

import org.wahlzeit.PatternInstance;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "Singleton",
        participants = {"CarPhotoManager", "PhotoManager"}
)
public class CarPhotoManager extends PhotoManager {

    protected static final CarPhotoManager instance = new CarPhotoManager();

    private static final Logger log = Logger.getLogger(CarPhotoManager.class.getName());

    /**
     * @MethodType Quere
     */
    public static final CarPhotoManager getInstance() {
        return instance;
    }

    /**
     * @methodtype constructor
     */
    public CarPhotoManager() {
        photoTagCollector = CarPhotoFactory.getInstance().createPhotoTagCollector();
    }

    /**meth
     * @MethodType Quere
     */
    @Override
    public Photo getPhotoFromId(PhotoId id) {
        if (id != null) {
            Photo photo = super.doGetPhotoFromId(id);
            if (photo != null) {
                super.doAddPhoto(photo);
            } else {
                photo = CarPhotoFactory.getInstance().loadPhoto(id);
            }
            return photo;
        }
        return null;
    }

    /**
     * @MethodType Quere
     */
    public Photo getPhoto(PhotoId id) {
        if (id != null)
            return getPhotoFromId(id);
          new NullPointerException();
          return null;
    }
}
