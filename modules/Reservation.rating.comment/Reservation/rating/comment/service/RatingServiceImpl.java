package Reservation.rating.comment.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Reservation.rating.core.service.RatingServiceDecorator;
import Reservation.rating.core.model.RatingImpl;
import Reservation.rating.core.service.RatingServiceComponent;
import Reservation.rating.core.model.Rating;
import Reservation.rating.core.model.RatingDecorator;
import Reservation.rating.RatingFactory;

public class RatingServiceImpl extends RatingServiceDecorator {
    public RatingServiceImpl (RatingServiceComponent record) {
        super(record);
    }

 	public Rating createRating(Map<String, Object> requestBody){
		String komentar = (String) requestBody.get("komentar");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		String scoreStr = (String) requestBody.get("score");
		int score = Integer.parseInt(scoreStr);
		Rating ratingcomment = record.createRating(requestBody);
		Rating ratingcommentdeco = RatingFactory.createRating("Reservation.rating.comment.model.RatingImpl", ratingcomment,  komentar);
		Repository.saveObject(ratingcommentdeco);
		return ratingcommentdeco;
	}

	public Rating createRating(Map<String, Object> requestBody, int id){
		Rating savedRating = Repository.getObject(id);
		String komentar = (String) requestBody.get("komentar");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		String scoreStr = (String) requestBody.get("score");
		int score = Integer.parseInt(scoreStr);
		int recordRatingIdRating = ((RatingDecorator) savedRating).getIdRating();
		Rating Rating = record.createRating(requestBody, recordRatingIdRating);
		Rating ratingcomment = RatingFactory.createRating("Reservation.rating.comment.model.RatingImpl", Rating,  komentar);
		return ratingcomment;
	}

    public HashMap<String, Object> updateRating(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idRating");
		int id = Integer.parseInt(idStr);
		
		Rating ratingcomment = Repository.getObject(id);
		String idResourceStr = (String) requestBody.get("idResource");
		ratingcomment.setIdResource(Integer.parseInt(idResourceStr));
		String scoreStr = (String) requestBody.get("score");
		ratingcomment.setScore(Integer.parseInt(scoreStr));
		((Reservation.rating.comment.model.RatingImpl) ratingcomment).setKomentar((String) requestBody.get("komentar"));
		
		Repository.updateObject(ratingcomment);
		
		//to do: fix association attributes
		
		return ratingcomment.toHashMap();
	}

	public HashMap<String, Object> getRating(String idStr){
		int id = Integer.parseInt(idStr);
		Rating ratingcomment = Repository.getObject(id);
		return ratingcomment.toHashMap();
	}

	public HashMap<String, Object> getRatingById(int id){
		List<HashMap<String, Object>> ratingList = getAllRating();
		for (HashMap<String, Object> rating : ratingList){
			int rating_id = ((Double) rating.get("idrating")).intValue();
			if (rating_id == id){
				return rating;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllRating(){
		List<Rating> List = Repository.getAllObject("rating_comment");
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
