package Reservation.cancellation.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.cancellation.core.model.Cancellation;

public abstract class CancellationServiceDecorator extends CancellationServiceComponent{
	protected CancellationServiceComponent record;

    public CancellationServiceDecorator(CancellationServiceComponent record) {
        this.record = record;
    }

	public Cancellation createCancellation(Map<String, Object> requestBody){
		return record.createCancellation(requestBody);
	}
	
	public Cancellation createCancellation(Map<String, Object> requestBody, int id){
		return record.createCancellation(requestBody, id);
	}

	public HashMap<String, Object> getCancellation(Map<String, Object> requestBody){
		return record.getCancellation(requestBody);
	}

	public List<HashMap<String,Object>> getAllCancellation(){
		return record.getAllCancellation();
	}

    public HashMap<String, Object> updateCancellation(Map<String, Object> requestBody){
		return record.updateCancellation(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Cancellation> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCancellation(Map<String, Object> requestBody){
		return record.deleteCancellation(requestBody);
	}

	public HashMap<String, Object> getCancellationById(int id){
        return record.getCancellationById(id);
    }

}
