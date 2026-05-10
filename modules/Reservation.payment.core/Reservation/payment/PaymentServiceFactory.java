package Reservation.payment;

import Reservation.payment.core.service.PaymentService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PaymentServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(PaymentServiceFactory.class.getName());

    public PaymentServiceFactory() {}

    public static PaymentService createPaymentService(String fullyQualifiedName, Object ... base) {
        PaymentService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PaymentService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PaymentService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PaymentService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PaymentService.");
            System.exit(50);
        }
        return record;
    }
}
