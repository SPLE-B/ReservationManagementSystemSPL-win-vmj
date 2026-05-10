package Reservation.cancellation.core.service;
import java.util.*;

import Reservation.cancellation.core.model.Cancellation;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface CancellationService {
	Cancellation createCancellation(Map<String, Object> requestBody);
	HashMap<String, Object> getCancellation(Map<String, Object> requestBody);
    HashMap<String, Object> updateCancellation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllCancellation();
    List<HashMap<String,Object>> deleteCancellation(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Cancellation> List);
}
