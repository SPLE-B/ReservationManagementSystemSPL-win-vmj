package Reservation.resource.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.resource.core.model.Resource;
//add other required packages

public abstract class ResourceServiceComponent implements ResourceService{
	protected RepositoryUtil<Resource> Repository;

    public ResourceServiceComponent(){
        this.Repository = new RepositoryUtil<Resource>(Reservation.resource.core.model.ResourceComponent.class);
    }	

    public abstract Resource createResource(Map<String, Object> requestBody);
	public abstract Resource createResource(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateResource(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getResource(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllResource();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Resource> List);
    public abstract List<HashMap<String,Object>> deleteResource(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getResourceById(int id);

}
