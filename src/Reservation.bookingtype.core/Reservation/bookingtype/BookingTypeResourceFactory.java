package Reservation.bookingtype;

import Reservation.bookingtype.core.resource.BookingTypeResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class BookingTypeResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(BookingTypeResourceFactory.class.getName());

    public BookingTypeResourceFactory() {}

    public static BookingTypeResource createBookingTypeResource(String fullyQualifiedName, Object ... base) {
        BookingTypeResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (BookingTypeResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of BookingTypeResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to BookingTypeResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating BookingTypeResource.");
            System.exit(50);
        }
        return record;
    }
}
