package Reservation.payment.core.service;
import java.util.*;

import Reservation.payment.core.model.Payment;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PaymentService {
	Payment createPayment(Map<String, Object> requestBody);
	HashMap<String, Object> getPayment(Map<String, Object> requestBody);
    HashMap<String, Object> updatePayment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllPayment();
    List<HashMap<String,Object>> deletePayment(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Payment> List);
}
