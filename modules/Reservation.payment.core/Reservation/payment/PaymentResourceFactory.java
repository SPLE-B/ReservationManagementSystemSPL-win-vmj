package Reservation.payment;

import Reservation.payment.core.resource.PaymentResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PaymentResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(PaymentResourceFactory.class.getName());

    public PaymentResourceFactory() {}

    public static PaymentResource createPaymentResource(String fullyQualifiedName, Object ... base) {
        PaymentResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PaymentResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PaymentResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PaymentResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PaymentResource.");
            System.exit(50);
        }
        return record;
    }
}
