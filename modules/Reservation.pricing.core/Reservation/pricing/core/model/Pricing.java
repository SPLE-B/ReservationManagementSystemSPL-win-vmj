package Reservation.pricing.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Pricing {
	    public int getIdPricing();
	    public void setIdPricing(int idPricing);
	    public int getBasePrice();
	    public void setBasePrice(int basePrice);
	    public int getIdResource();
	    public void setIdResource(int idResource);
	HashMap<String, Object> toHashMap();
}
