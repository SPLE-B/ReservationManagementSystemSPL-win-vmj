package Reservation.rating.core.resource;
import java.util.*;

import Reservation.rating.core.model.Rating;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface RatingResource {
    List<HashMap<String,Object>> saveRating(VMJExchange vmjExchange);
    HashMap<String, Object> updateRating(VMJExchange vmjExchange);
    HashMap<String, Object> getRating(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllRating(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteRating(VMJExchange vmjExchange);
}
