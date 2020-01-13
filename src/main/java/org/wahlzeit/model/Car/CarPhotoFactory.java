package org.wahlzeit.model.Car;

import org.wahlzeit.PatternInstance;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"CarPhotoFactory", "PhotoFactory"}
)
public class CarPhotoFactory extends PhotoFactory {
    private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     *
     * @MethodType Helper
     */
    private static CarPhotoFactory instance = null;

    public CarPhotoFactory() {

    }

    /**
     * @MethodType Helper
     */
    public static synchronized CarPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new CarPhotoFactory());
        }

        return instance;
    }

    public static Logger getLog() {
        return log;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     *
     * @MethodType Mutation
     */
    protected static synchronized void setInstance(CarPhotoFactory carPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize CarFactory twice");
        }

        instance = carPhotoFactory;
    }

    /**
     * @MethodType Helper
     */
    public Photo createPhoto() {
        return new CarPhoto();
    }

    /**
     * @MethodType Helper
     */
    public Photo createPhoto(PhotoId id) {
        return new CarPhoto(id);
    }

}
