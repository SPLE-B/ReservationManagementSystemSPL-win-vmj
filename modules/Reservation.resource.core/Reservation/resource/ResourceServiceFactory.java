package Reservation.resource;

import Reservation.resource.core.service.ResourceService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ResourceServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ResourceServiceFactory.class.getName());

    public ResourceServiceFactory() {}

    public static ResourceService createResourceService(String fullyQualifiedName, Object ... base) {
        ResourceService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ResourceService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ResourceService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ResourceService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ResourceService.");
            System.exit(50);
        }
        return record;
    }
}
