package Reservation.rating.core.service;
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
import Reservation.rating.RatingFactory;
import Reservation.rating.core.model.Rating;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class RatingServiceImpl extends RatingServiceComponent{

    public Rating createRating(Map<String, Object> requestBody){
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		String scoreStr = (String) requestBody.get("score");
		int score = Integer.parseInt(scoreStr);
		
		//to do: fix association attributes
		
		Rating rating = RatingFactory.createRating("Reservation.rating.core.model.RatingImpl", idResource, score);
		Repository.saveObject(rating);
		return rating;
	}

	public Rating createRating(Map<String, Object> requestBody, int id){
		int idRating = id;
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		String scoreStr = (String) requestBody.get("score");
		int score = Integer.parseInt(scoreStr);
		
		//to do: fix association attributes
		Rating rating = RatingFactory.createRating("Reservation.rating.core.model.RatingImpl",idRating, idResource, score);
		Repository.saveObject(rating);
		return rating;
	}

    public HashMap<String, Object> updateRating(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idRating");
		int id = Integer.parseInt(idStr);
		Rating rating = Repository.getObject(id);
		
		String idResourceStr = (String) requestBody.get("idResource");
		rating.setIdResource(Integer.parseInt(idResourceStr));
		
		String scoreStr = (String) requestBody.get("score");
		rating.setScore(Integer.parseInt(scoreStr));
		
		
		Repository.updateObject(rating);
		
		//to do: fix association attributes
		
		return rating.toHashMap();
		
	}

    public HashMap<String, Object> getRating(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idRating"); 
		int id = Integer.parseInt(idStr);
		Rating rating = Repository.getObject(id);
		return rating.toHashMap();
	}

	public HashMap<String, Object> getRatingById(int id){
		List<HashMap<String, Object>> ratingList = getAllRating();
		for (HashMap<String, Object> rating : ratingList){
			int record_id = ((Double) rating.get("idRating")).intValue();
			if (record_id == id){
				return rating;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllRating(){
		List<Rating> List = Repository.getAllObject("rating_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Rating> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteRating(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idRating"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllRating();
	}

}
