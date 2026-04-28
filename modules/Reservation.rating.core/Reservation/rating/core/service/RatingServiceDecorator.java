package Reservation.rating.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.rating.core.model.Rating;

public abstract class RatingServiceDecorator extends RatingServiceComponent{
	protected RatingServiceComponent record;

    public RatingServiceDecorator(RatingServiceComponent record) {
        this.record = record;
    }

	public Rating createRating(Map<String, Object> requestBody){
		return record.createRating(requestBody);
	}
	
	public Rating createRating(Map<String, Object> requestBody, int id){
		return record.createRating(requestBody, id);
	}

	public HashMap<String, Object> getRating(Map<String, Object> requestBody){
		return record.getRating(requestBody);
	}

	public List<HashMap<String,Object>> getAllRating(){
		return record.getAllRating();
	}

    public HashMap<String, Object> updateRating(Map<String, Object> requestBody){
		return record.updateRating(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Rating> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteRating(Map<String, Object> requestBody){
		return record.deleteRating(requestBody);
	}

	public HashMap<String, Object> getRatingById(int id){
        return record.getRatingById(id);
    }

}
