package Reservation.rating.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.rating.core.model.Rating;
//add other required packages

public abstract class RatingServiceComponent implements RatingService{
	protected RepositoryUtil<Rating> Repository;

    public RatingServiceComponent(){
        this.Repository = new RepositoryUtil<Rating>(Reservation.rating.core.model.RatingComponent.class);
    }	

    public abstract Rating createRating(Map<String, Object> requestBody);
	public abstract Rating createRating(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateRating(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getRating(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllRating();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Rating> List);
    public abstract List<HashMap<String,Object>> deleteRating(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getRatingById(int id);

}
