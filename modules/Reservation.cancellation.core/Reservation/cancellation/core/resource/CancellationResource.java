package Reservation.cancellation.core.resource;
import java.util.*;

import Reservation.cancellation.core.model.Cancellation;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface CancellationResource {
    List<HashMap<String,Object>> saveCancellation(VMJExchange vmjExchange);
    HashMap<String, Object> updateCancellation(VMJExchange vmjExchange);
    HashMap<String, Object> getCancellation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCancellation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCancellation(VMJExchange vmjExchange);
}
