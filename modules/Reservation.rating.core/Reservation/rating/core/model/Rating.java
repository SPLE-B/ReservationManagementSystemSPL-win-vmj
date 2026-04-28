package Reservation.rating.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Rating {
	    public int getIdRating();
	    public void setIdRating(int idRating);
	    public int getIdResource();
	    public void setIdResource(int idResource);
	    public int getScore();
	    public void setScore(int score);
	HashMap<String, Object> toHashMap();
}
