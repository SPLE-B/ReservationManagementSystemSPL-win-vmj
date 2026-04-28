package Reservation.cancellation;

import Reservation.cancellation.core.service.CancellationService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CancellationServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(CancellationServiceFactory.class.getName());

    public CancellationServiceFactory() {}

    public static CancellationService createCancellationService(String fullyQualifiedName, Object ... base) {
        CancellationService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (CancellationService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CancellationService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to CancellationService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating CancellationService.");
            System.exit(50);
        }
        return record;
    }
}
