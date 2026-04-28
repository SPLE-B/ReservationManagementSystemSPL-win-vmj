package Reservation.pricing.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.pricing.core.model.Pricing;

public abstract class PricingServiceDecorator extends PricingServiceComponent{
	protected PricingServiceComponent record;

    public PricingServiceDecorator(PricingServiceComponent record) {
        this.record = record;
    }

	public Pricing createPricing(Map<String, Object> requestBody){
		return record.createPricing(requestBody);
	}
	
	public Pricing createPricing(Map<String, Object> requestBody, int id){
		return record.createPricing(requestBody, id);
	}

	public HashMap<String, Object> getPricing(Map<String, Object> requestBody){
		return record.getPricing(requestBody);
	}

	public List<HashMap<String,Object>> getAllPricing(){
		return record.getAllPricing();
	}

    public HashMap<String, Object> updatePricing(Map<String, Object> requestBody){
		return record.updatePricing(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pricing> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePricing(Map<String, Object> requestBody){
		return record.deletePricing(requestBody);
	}

	public HashMap<String, Object> getPricingById(int id){
        return record.getPricingById(id);
    }

}
