package Reservation.pricing.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.pricing.core.model.Pricing;
//add other required packages

public abstract class PricingServiceComponent implements PricingService{
	protected RepositoryUtil<Pricing> Repository;

    public PricingServiceComponent(){
        this.Repository = new RepositoryUtil<Pricing>(Reservation.pricing.core.model.PricingComponent.class);
    }	

    public abstract Pricing createPricing(Map<String, Object> requestBody);
	public abstract Pricing createPricing(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updatePricing(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPricing(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPricing();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Pricing> List);
    public abstract List<HashMap<String,Object>> deletePricing(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPricingById(int id);

}
