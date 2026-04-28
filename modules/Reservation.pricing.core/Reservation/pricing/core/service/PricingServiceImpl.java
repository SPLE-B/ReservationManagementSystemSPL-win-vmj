package Reservation.pricing.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.pricing.PricingFactory;
import Reservation.pricing.core.model.Pricing;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class PricingServiceImpl extends PricingServiceComponent{

    public Pricing createPricing(Map<String, Object> requestBody){
		String basePriceStr = (String) requestBody.get("basePrice");
		int basePrice = Integer.parseInt(basePriceStr);
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		
		//to do: fix association attributes
		
		Pricing pricing = PricingFactory.createPricing("Reservation.pricing.core.model.PricingImpl", basePrice, idResource);
		Repository.saveObject(pricing);
		return pricing;
	}

	public Pricing createPricing(Map<String, Object> requestBody, int id){
		int idPricing = id;
		String basePriceStr = (String) requestBody.get("basePrice");
		int basePrice = Integer.parseInt(basePriceStr);
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		
		//to do: fix association attributes
		Pricing pricing = PricingFactory.createPricing("Reservation.pricing.core.model.PricingImpl",idPricing, basePrice, idResource);
		Repository.saveObject(pricing);
		return pricing;
	}

    public HashMap<String, Object> updatePricing(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPricing");
		int id = Integer.parseInt(idStr);
		Pricing pricing = Repository.getObject(id);
		
		String basePriceStr = (String) requestBody.get("basePrice");
		pricing.setBasePrice(Integer.parseInt(basePriceStr));
		
		String idResourceStr = (String) requestBody.get("idResource");
		pricing.setIdResource(Integer.parseInt(idResourceStr));
		
		
		Repository.updateObject(pricing);
		
		//to do: fix association attributes
		
		return pricing.toHashMap();
		
	}

    public HashMap<String, Object> getPricing(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPricing"); 
		int id = Integer.parseInt(idStr);
		Pricing pricing = Repository.getObject(id);
		return pricing.toHashMap();
	}

	public HashMap<String, Object> getPricingById(int id){
		List<HashMap<String, Object>> pricingList = getAllPricing();
		for (HashMap<String, Object> pricing : pricingList){
			int record_id = ((Double) pricing.get("idPricing")).intValue();
			if (record_id == id){
				return pricing;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPricing(){
		List<Pricing> List = Repository.getAllObject("pricing_impl");
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
