package Reservation.rating;

import Reservation.rating.core.service.RatingService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class RatingServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(RatingServiceFactory.class.getName());

    public RatingServiceFactory() {}

    public static RatingService createRatingService(String fullyQualifiedName, Object ... base) {
        RatingService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (RatingService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of RatingService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to RatingService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating RatingService.");
            System.exit(50);
        }
        return record;
    }
}
