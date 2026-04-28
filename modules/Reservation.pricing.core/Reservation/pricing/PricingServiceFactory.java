package Reservation.pricing;

import Reservation.pricing.core.service.PricingService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PricingServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(PricingServiceFactory.class.getName());

    public PricingServiceFactory() {}

    public static PricingService createPricingService(String fullyQualifiedName, Object ... base) {
        PricingService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PricingService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PricingService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PricingService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PricingService.");
            System.exit(50);
        }
        return record;
    }
}
