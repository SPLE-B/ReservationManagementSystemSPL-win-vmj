package Reservation.resource.core.service;
import java.util.*;

import Reservation.resource.core.model.Resource;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ResourceService {
	Resource createResource(Map<String, Object> requestBody);
	HashMap<String, Object> getResource(Map<String, Object> requestBody);
    HashMap<String, Object> updateResource(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllResource();
    List<HashMap<String,Object>> deleteResource(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Resource> List);
}
