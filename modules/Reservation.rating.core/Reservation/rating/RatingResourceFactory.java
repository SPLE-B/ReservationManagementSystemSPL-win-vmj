package Reservation.rating;

import Reservation.rating.core.resource.RatingResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class RatingResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(RatingResourceFactory.class.getName());

    public RatingResourceFactory() {}

    public static RatingResource createRatingResource(String fullyQualifiedName, Object ... base) {
        RatingResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (RatingResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of RatingResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to RatingResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating RatingResource.");
            System.exit(50);
        }
        return record;
    }
}
