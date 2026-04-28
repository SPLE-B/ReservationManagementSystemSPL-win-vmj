package Reservation.cancellation;

import Reservation.cancellation.core.resource.CancellationResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CancellationResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(CancellationResourceFactory.class.getName());

    public CancellationResourceFactory() {}

    public static CancellationResource createCancellationResource(String fullyQualifiedName, Object ... base) {
        CancellationResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (CancellationResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CancellationResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to CancellationResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating CancellationResource.");
            System.exit(50);
        }
        return record;
    }
}
