package Reservation.bookingtype;

import Reservation.bookingtype.core.service.BookingTypeService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class BookingTypeServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(BookingTypeServiceFactory.class.getName());

    public BookingTypeServiceFactory() {}

    public static BookingTypeService createBookingTypeService(String fullyQualifiedName, Object ... base) {
        BookingTypeService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (BookingTypeService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of BookingTypeService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to BookingTypeService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating BookingTypeService.");
            System.exit(50);
        }
        return record;
    }
}
