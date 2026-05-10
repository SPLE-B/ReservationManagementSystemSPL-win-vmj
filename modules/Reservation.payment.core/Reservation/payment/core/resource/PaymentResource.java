package Reservation.payment.core.resource;
import java.util.*;

import Reservation.payment.core.model.Payment;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PaymentResource {
    List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange);
    HashMap<String, Object> updatePayment(VMJExchange vmjExchange);
    HashMap<String, Object> getPayment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange);
}
