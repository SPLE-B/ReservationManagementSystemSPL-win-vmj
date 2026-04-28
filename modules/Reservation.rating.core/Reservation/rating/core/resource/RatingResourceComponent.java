package Reservation.rating.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.rating.core.model.Rating;
//add other required packages

public abstract class RatingResourceComponent implements RatingResource{
	
	public RatingResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveRating(VMJExchange vmjExchange);
    public abstract Rating createRating(VMJExchange vmjExchange);
	public abstract Rating createRating(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateRating(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getRating(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllRating(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteRating(VMJExchange vmjExchange);

}
