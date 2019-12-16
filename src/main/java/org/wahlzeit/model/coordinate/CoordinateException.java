package org.wahlzeit.model.coordinate;

public final  class CoordinateException extends Exception {

    public CoordinateException(String message) {
        super(message);
    }

    public CoordinateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordinateException(Throwable cause) {
        super(cause);
    }

    public CoordinateException(String message, String className, double value) {
        super(message + " Invalid value:" + value + "   in class: " + className);
    }



}
