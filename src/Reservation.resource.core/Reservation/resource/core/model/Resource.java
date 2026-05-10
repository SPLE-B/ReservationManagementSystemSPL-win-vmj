package Reservation.resource.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Resource {
	    public int getIdResource();
	    public void setIdResource(int idResource);
	    public String getName();
	    public void setName(String name);
	    public String getTypeResource();
	    public void setTypeResource(String typeResource);
	    public String getLocation();
	    public void setLocation(String location);
	HashMap<String, Object> toHashMap();
}
