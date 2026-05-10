package Reservation.pricing.core.resource;
import java.util.*;

import Reservation.pricing.core.model.Pricing;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface PricingResource {
    List<HashMap<String,Object>> savePricing(VMJExchange vmjExchange);
    HashMap<String, Object> updatePricing(VMJExchange vmjExchange);
    HashMap<String, Object> getPricing(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPricing(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePricing(VMJExchange vmjExchange);
}
