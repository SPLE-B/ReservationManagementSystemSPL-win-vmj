package Reservation.cancellation.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.cancellation.core.model.Cancellation;
//add other required packages

public abstract class CancellationResourceComponent implements CancellationResource{
	
	public CancellationResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveCancellation(VMJExchange vmjExchange);
    public abstract Cancellation createCancellation(VMJExchange vmjExchange);
	public abstract Cancellation createCancellation(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateCancellation(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCancellation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllCancellation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteCancellation(VMJExchange vmjExchange);

}
