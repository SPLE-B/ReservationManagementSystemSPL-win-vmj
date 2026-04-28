package Reservation.resource;

import Reservation.resource.core.resource.ResourceResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ResourceResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ResourceResourceFactory.class.getName());

    public ResourceResourceFactory() {}

    public static ResourceResource createResourceResource(String fullyQualifiedName, Object ... base) {
        ResourceResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ResourceResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ResourceResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ResourceResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ResourceResource.");
            System.exit(50);
        }
        return record;
    }
}
