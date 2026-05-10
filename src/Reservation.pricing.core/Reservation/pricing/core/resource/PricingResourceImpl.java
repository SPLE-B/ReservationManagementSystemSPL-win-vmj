package Reservation.pricing.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.pricing.PricingFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Reservation.pricing.core.model.Pricing;
import Reservation.pricing.core.service.PricingServiceImpl;
//add other required packages


public class PricingResourceImpl extends PricingResourceComponent{
	
	private PricingServiceImpl pricingServiceImpl = new PricingServiceImpl();

	
    @Route(url="call/pricing/save")
    public List<HashMap<String,Object>> savePricing(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pricing pricing = createPricing(vmjExchange);
		return pricingServiceImpl.getAllPricing();
	}

    public Pricing createPricing(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pricing result = pricingServiceImpl.createPricing(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Pricing createPricing(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pricing result = pricingServiceImpl.createPricing(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/pricing/update")
    public HashMap<String, Object> updatePricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return pricingServiceImpl.updatePricing(requestBody);
		
	}

	
    @Route(url="call/pricing/detail")
    public HashMap<String, Object> getPricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return pricingServiceImpl.getPricing(requestBody);
	}

	
    @Route(url="call/pricing/list")
    public List<HashMap<String,Object>> getAllPricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return pricingServiceImpl.getAllPricing();
	}

	
    @Route(url="call/pricing/delete")
    public List<HashMap<String,Object>> deletePricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return pricingServiceImpl.deletePricing(requestBody);
	}


}
