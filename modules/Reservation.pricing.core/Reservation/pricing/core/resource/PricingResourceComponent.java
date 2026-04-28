package Reservation.pricing.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.pricing.core.model.Pricing;
//add other required packages

public abstract class PricingResourceComponent implements PricingResource{
	
	public PricingResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> savePricing(VMJExchange vmjExchange);
    public abstract Pricing createPricing(VMJExchange vmjExchange);
	public abstract Pricing createPricing(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updatePricing(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPricing(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPricing(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePricing(VMJExchange vmjExchange);

}
