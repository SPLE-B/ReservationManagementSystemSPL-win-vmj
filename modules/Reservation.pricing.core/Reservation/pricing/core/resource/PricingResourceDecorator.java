package Reservation.pricing.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.pricing.core.model.Pricing;

public abstract class PricingResourceDecorator extends PricingResourceComponent{
	protected PricingResourceComponent record;

    public PricingResourceDecorator(PricingResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> savePricing(VMJExchange vmjExchange){
		return record.savePricing(vmjExchange);
	}

    public Pricing createPricing(VMJExchange vmjExchange){
		return record.createPricing(vmjExchange);
	}
	
	public Pricing createPricing(VMJExchange vmjExchange, int id){
		return record.createPricing(vmjExchange, id);
	}

    public HashMap<String, Object> updatePricing(VMJExchange vmjExchange){
		return record.updatePricing(vmjExchange);
	}

    public HashMap<String, Object> getPricing(VMJExchange vmjExchange){
		return record.getPricing(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPricing(VMJExchange vmjExchange){
		return record.getAllPricing(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePricing(VMJExchange vmjExchange){
		return record.deletePricing(vmjExchange);
	}

}
