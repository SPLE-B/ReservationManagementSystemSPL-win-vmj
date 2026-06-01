package Reservation.pricing.dynamic.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Reservation.pricing.core.resource.PricingResourceDecorator;
import Reservation.pricing.core.resource.PricingResourceComponent;
import Reservation.pricing.core.model.Pricing;
import Reservation.pricing.core.model.PricingImpl;
import Reservation.pricing.core.service.PricingServiceComponent;
import Reservation.pricing.dynamic.service.PricingServiceImpl;

public class PricingResourceImpl extends PricingResourceDecorator {
	protected PricingServiceComponent recordComponent;
	private PricingServiceImpl pricingdynamicServiceImpl;

    public PricingResourceImpl (PricingResourceComponent record) {
        super(record);
		this.recordComponent = new Reservation.pricing.core.service.PricingServiceImpl();
		this.pricingdynamicServiceImpl = new PricingServiceImpl(recordComponent);
    }

    
    @Route(url="call/dynamic/save")
    public List<HashMap<String,Object>> savePricing(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Pricing pricingdynamic = createPricing(vmjExchange);
		return getAllPricing(vmjExchange);
	}

    public Pricing createPricing(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pricing result = pricingdynamicServiceImpl.createPricing(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Pricing createPricing(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Pricing result = pricingdynamicServiceImpl.createPricing(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/dynamic/update")
    public HashMap<String, Object> updatePricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return pricingdynamicServiceImpl.updatePricing(requestBody);
	}

	
    @Route(url="call/dynamic/detail")
    public HashMap<String, Object> getPricing(VMJExchange vmjExchange){
		return record.getPricing(vmjExchange);
	}

	
    @Route(url="call/dynamic/list")
    public List<HashMap<String,Object>> getAllPricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return pricingdynamicServiceImpl.getAllPricing();
	}

    public List<HashMap<String,Object>> transformPricingListToHashMap(List<Pricing> PricingDynamicList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PricingDynamicList.size(); i++) {
            resultList.add(PricingDynamicList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/dynamic/delete")
    public List<HashMap<String,Object>> deletePricing(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return pricingdynamicServiceImpl.deletePricing(requestBody);
	}

	
}
