package Reservation.rating.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.rating.core.model.Rating;

public abstract class RatingResourceDecorator extends RatingResourceComponent{
	protected RatingResourceComponent record;

    public RatingResourceDecorator(RatingResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveRating(VMJExchange vmjExchange){
		return record.saveRating(vmjExchange);
	}

    public Rating createRating(VMJExchange vmjExchange){
		return record.createRating(vmjExchange);
	}
	
	public Rating createRating(VMJExchange vmjExchange, int id){
		return record.createRating(vmjExchange, id);
	}

    public HashMap<String, Object> updateRating(VMJExchange vmjExchange){
		return record.updateRating(vmjExchange);
	}

    public HashMap<String, Object> getRating(VMJExchange vmjExchange){
		return record.getRating(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllRating(VMJExchange vmjExchange){
		return record.getAllRating(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteRating(VMJExchange vmjExchange){
		return record.deleteRating(vmjExchange);
	}

}
