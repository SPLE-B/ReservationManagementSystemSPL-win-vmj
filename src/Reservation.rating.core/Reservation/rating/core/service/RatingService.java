package Reservation.rating.core.service;
import java.util.*;

import Reservation.rating.core.model.Rating;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface RatingService {
	Rating createRating(Map<String, Object> requestBody);
	HashMap<String, Object> getRating(Map<String, Object> requestBody);
    HashMap<String, Object> updateRating(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllRating();
    List<HashMap<String,Object>> deleteRating(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Rating> List);
}
