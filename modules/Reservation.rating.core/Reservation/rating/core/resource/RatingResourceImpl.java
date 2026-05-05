package Reservation.rating.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.rating.RatingFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Reservation.rating.core.model.Rating;
import Reservation.rating.core.service.RatingServiceImpl;
//add other required packages


public class RatingResourceImpl extends RatingResourceComponent{
	
	private RatingServiceImpl ratingServiceImpl = new RatingServiceImpl();

	
    @Route(url="call/rating/save")
    public List<HashMap<String,Object>> saveRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Rating rating = createRating(vmjExchange);
		return ratingServiceImpl.getAllRating();
	}

    public Rating createRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Rating result = ratingServiceImpl.createRating(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Rating createRating(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Rating result = ratingServiceImpl.createRating(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/rating/update")
    public HashMap<String, Object> updateRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return ratingServiceImpl.updateRating(requestBody);
		
	}

	
    @Route(url="call/rating/detail")
    public HashMap<String, Object> getRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return ratingServiceImpl.getRating(requestBody);
	}

	
    @Route(url="call/rating/list")
    public List<HashMap<String,Object>> getAllRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ratingServiceImpl.getAllRating();
	}

	
    @Route(url="call/rating/delete")
    public List<HashMap<String,Object>> deleteRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return ratingServiceImpl.deleteRating(requestBody);
	}


}
