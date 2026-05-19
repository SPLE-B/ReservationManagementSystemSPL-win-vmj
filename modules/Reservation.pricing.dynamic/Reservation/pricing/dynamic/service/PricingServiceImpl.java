package Reservation.pricing.dynamic.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Reservation.pricing.core.service.PricingServiceDecorator;
import Reservation.pricing.core.model.PricingImpl;
import Reservation.pricing.core.service.PricingServiceComponent;
import Reservation.pricing.core.model.Pricing;
import Reservation.pricing.core.model.PricingDecorator;
import Reservation.pricing.PricingFactory;

public class PricingServiceImpl extends PricingServiceDecorator {
    public PricingServiceImpl (PricingServiceComponent record) {
        super(record);
    }

 	public Pricing createPricing(Map<String, Object> requestBody){
		String peakPercentageStr = (String) requestBody.get("peakPercentage");
		int peakPercentage = Integer.parseInt(peakPercentageStr);
		String basePriceStr = (String) requestBody.get("basePrice");
		int basePrice = Integer.parseInt(basePriceStr);
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		Pricing pricingdynamic = record.createPricing(requestBody);
		Pricing pricingdynamicdeco = PricingFactory.createPricing("Reservation.pricing.dynamic.model.PricingImpl", pricingdynamic, peakPercentage);
		Repository.saveObject(pricingdynamicdeco);
		return pricingdynamicdeco;
	}

	public Pricing createPricing(Map<String, Object> requestBody, int id){
		Pricing savedPricing = Repository.getObject(id);
		String peakPercentageStr = (String) requestBody.get("peakPercentage");
		int peakPercentage = Integer.parseInt(peakPercentageStr);
		int recordPricingIdPricing = ((PricingDecorator) savedPricing).getIdPricing();
		Pricing pricing = record.createPricing(requestBody, recordPricingIdPricing);
		Pricing pricingdynamic = PricingFactory.createPricing("Reservation.pricing.dynamic.model.PricingImpl", pricing, peakPercentage);
		return pricingdynamic;
	}

    public HashMap<String, Object> updatePricing(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPricing");
		int id = Integer.parseInt(idStr);
		
		Pricing pricingdynamic = Repository.getObject(id);
		pricingdynamic = createPricing(requestBody, id);
		
		Repository.updateObject(pricingdynamic);
		pricingdynamic = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return pricingdynamic.toHashMap();
	}

	public HashMap<String, Object> getPricing(String idStr){
		int id = Integer.parseInt(idStr);
		Pricing pricingdynamic = Repository.getObject(id);
		return pricingdynamic.toHashMap();
	}

	public HashMap<String, Object> getPricingById(int id){
		List<HashMap<String, Object>> pricingList = getAllPricing();
		for (HashMap<String, Object> pricing : pricingList){
			int pricing_id = ((Double) pricing.get("idpricing")).intValue();
			if (pricing_id == id){
				return pricing;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPricing(){
		List<Pricing> List = Repository.getAllObject("pricing_dynamic");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Pricing> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePricing(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idPricing"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPricing();
	}

	
}
