package Reservation.resource.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.resource.ResourceFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Reservation.resource.core.model.Resource;
import Reservation.resource.core.service.ResourceServiceImpl;
//add other required packages


public class ResourceResourceImpl extends ResourceResourceComponent{
	
	private ResourceServiceImpl resourceServiceImpl = new ResourceServiceImpl();

	
    @Route(url="call/resource/save")
    public List<HashMap<String,Object>> saveResource(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Resource resource = createResource(vmjExchange);
		return resourceServiceImpl.getAllResource();
	}

    public Resource createResource(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Resource result = resourceServiceImpl.createResource(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Resource createResource(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Resource result = resourceServiceImpl.createResource(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/resource/update")
    public HashMap<String, Object> updateResource(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return resourceServiceImpl.updateResource(requestBody);
		
	}

	
    @Route(url="call/resource/detail")
    public HashMap<String, Object> getResource(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return resourceServiceImpl.getResource(requestBody);
	}

	
    @Route(url="call/resource/list")
    public List<HashMap<String,Object>> getAllResource(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return resourceServiceImpl.getAllResource();
	}

	
    @Route(url="call/resource/delete")
    public List<HashMap<String,Object>> deleteResource(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return resourceServiceImpl.deleteResource(requestBody);
	}


}
