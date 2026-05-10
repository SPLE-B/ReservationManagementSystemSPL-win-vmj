package Reservation.cancellation.core.service;
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
import Reservation.cancellation.CancellationFactory;
import Reservation.cancellation.core.model.Cancellation;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class CancellationServiceImpl extends CancellationServiceComponent{

    public Cancellation createCancellation(Map<String, Object> requestBody){
		String idCancellationStr = (String) requestBody.get("idCancellation");
		int idCancellation = Integer.parseInt(idCancellationStr);
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String reason = (String) requestBody.get("reason");
		String cancelledAt = (String) requestBody.get("cancelledAt");
		
		//to do: fix association attributes
		
		Cancellation cancellation = CancellationFactory.createCancellation("Reservation.cancellation.core.model.CancellationImpl", idCancellation, idBooking, reason, cancelledAt);
		Repository.saveObject(cancellation);
		return cancellation;
	}

	public Cancellation createCancellation(Map<String, Object> requestBody, int id){
		String idCancellationStr = (String) requestBody.get("idCancellation");
		int idCancellation = Integer.parseInt(idCancellationStr);
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String reason = (String) requestBody.get("reason");
		String cancelledAt = (String) requestBody.get("cancelledAt");
		
		//to do: fix association attributes
		Cancellation cancellation = CancellationFactory.createCancellation("Reservation.cancellation.core.model.CancellationImpl",idCancellation, idBooking, reason, cancelledAt);
		Repository.saveObject(cancellation);
		return cancellation;
	}

    public HashMap<String, Object> updateCancellation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Cancellation cancellation = Repository.getObject(id);
		
		String idCancellationStr = (String) requestBody.get("idCancellation");
		cancellation.setIdCancellation(Integer.parseInt(idCancellationStr));
		
		String idBookingStr = (String) requestBody.get("idBooking");
		cancellation.setIdBooking(Integer.parseInt(idBookingStr));
		
		cancellation.setReason((String) requestBody.get("reason"));
		cancellation.setCancelledAt((String) requestBody.get("cancelledAt"));
		
		Repository.updateObject(cancellation);
		
		//to do: fix association attributes
		
		return cancellation.toHashMap();
		
	}

    public HashMap<String, Object> getCancellation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get(""); 
		int id = Integer.parseInt(idStr);
		Cancellation cancellation = Repository.getObject(id);
		return cancellation.toHashMap();
	}

	public HashMap<String, Object> getCancellationById(int id){
		List<HashMap<String, Object>> cancellationList = getAllCancellation();
		for (HashMap<String, Object> cancellation : cancellationList){
			int record_id = ((Double) cancellation.get("")).intValue();
			if (record_id == id){
				return cancellation;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllCancellation(){
		List<Cancellation> List = Repository.getAllObject("cancellation_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Cancellation> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCancellation(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCancellation();
	}

}
