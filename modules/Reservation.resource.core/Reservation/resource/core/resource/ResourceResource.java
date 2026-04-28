package Reservation.resource.core.resource;
import java.util.*;

import Reservation.resource.core.model.Resource;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ResourceResource {
    List<HashMap<String,Object>> saveResource(VMJExchange vmjExchange);
    HashMap<String, Object> updateResource(VMJExchange vmjExchange);
    HashMap<String, Object> getResource(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllResource(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteResource(VMJExchange vmjExchange);
}
