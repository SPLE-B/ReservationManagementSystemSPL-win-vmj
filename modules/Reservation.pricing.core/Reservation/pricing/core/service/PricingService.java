package Reservation.pricing.core.service;
import java.util.*;

import Reservation.pricing.core.model.Pricing;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PricingService {
	Pricing createPricing(Map<String, Object> requestBody);
	HashMap<String, Object> getPricing(Map<String, Object> requestBody);
    HashMap<String, Object> updatePricing(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllPricing();
    List<HashMap<String,Object>> deletePricing(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Pricing> List);
}
