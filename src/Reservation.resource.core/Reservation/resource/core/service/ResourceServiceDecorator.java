package Reservation.resource.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.resource.core.model.Resource;

public abstract class ResourceServiceDecorator extends ResourceServiceComponent{
	protected ResourceServiceComponent record;

    public ResourceServiceDecorator(ResourceServiceComponent record) {
        this.record = record;
    }

	public Resource createResource(Map<String, Object> requestBody){
		return record.createResource(requestBody);
	}
	
	public Resource createResource(Map<String, Object> requestBody, int id){
		return record.createResource(requestBody, id);
	}

	public HashMap<String, Object> getResource(Map<String, Object> requestBody){
		return record.getResource(requestBody);
	}

	public List<HashMap<String,Object>> getAllResource(){
		return record.getAllResource();
	}

    public HashMap<String, Object> updateResource(Map<String, Object> requestBody){
		return record.updateResource(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Resource> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteResource(Map<String, Object> requestBody){
		return record.deleteResource(requestBody);
	}

	public HashMap<String, Object> getResourceById(int id){
        return record.getResourceById(id);
    }

}
