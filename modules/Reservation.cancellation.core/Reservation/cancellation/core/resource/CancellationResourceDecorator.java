package Reservation.cancellation.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.cancellation.core.model.Cancellation;

public abstract class CancellationResourceDecorator extends CancellationResourceComponent{
	protected CancellationResourceComponent record;

    public CancellationResourceDecorator(CancellationResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveCancellation(VMJExchange vmjExchange){
		return record.saveCancellation(vmjExchange);
	}

    public Cancellation createCancellation(VMJExchange vmjExchange){
		return record.createCancellation(vmjExchange);
	}
	
	public Cancellation createCancellation(VMJExchange vmjExchange, int id){
		return record.createCancellation(vmjExchange, id);
	}

    public HashMap<String, Object> updateCancellation(VMJExchange vmjExchange){
		return record.updateCancellation(vmjExchange);
	}

    public HashMap<String, Object> getCancellation(VMJExchange vmjExchange){
		return record.getCancellation(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCancellation(VMJExchange vmjExchange){
		return record.getAllCancellation(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteCancellation(VMJExchange vmjExchange){
		return record.deleteCancellation(vmjExchange);
	}

}
