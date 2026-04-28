package Reservation.resource.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.resource.core.model.Resource;
//add other required packages

public abstract class ResourceResourceComponent implements ResourceResource{
	
	public ResourceResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveResource(VMJExchange vmjExchange);
    public abstract Resource createResource(VMJExchange vmjExchange);
	public abstract Resource createResource(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateResource(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getResource(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllResource(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteResource(VMJExchange vmjExchange);

}
