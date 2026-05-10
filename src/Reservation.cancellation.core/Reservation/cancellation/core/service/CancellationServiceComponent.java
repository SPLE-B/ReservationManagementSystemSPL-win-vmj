package Reservation.cancellation.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.cancellation.core.model.Cancellation;
//add other required packages

public abstract class CancellationServiceComponent implements CancellationService{
	protected RepositoryUtil<Cancellation> Repository;

    public CancellationServiceComponent(){
        this.Repository = new RepositoryUtil<Cancellation>(Reservation.cancellation.core.model.CancellationComponent.class);
    }	

    public abstract Cancellation createCancellation(Map<String, Object> requestBody);
	public abstract Cancellation createCancellation(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateCancellation(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCancellation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllCancellation();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Cancellation> List);
    public abstract List<HashMap<String,Object>> deleteCancellation(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getCancellationById(int id);

}
