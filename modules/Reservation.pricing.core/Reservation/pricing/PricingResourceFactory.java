package Reservation.pricing;

import Reservation.pricing.core.resource.PricingResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PricingResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(PricingResourceFactory.class.getName());

    public PricingResourceFactory() {}

    public static PricingResource createPricingResource(String fullyQualifiedName, Object ... base) {
        PricingResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PricingResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PricingResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PricingResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PricingResource.");
            System.exit(50);
        }
        return record;
    }
}
