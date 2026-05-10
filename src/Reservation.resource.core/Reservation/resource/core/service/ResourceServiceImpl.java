package Reservation.resource.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.resource.ResourceFactory;
import Reservation.resource.core.model.Resource;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ResourceServiceImpl extends ResourceServiceComponent{

    public Resource createResource(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String typeResource = (String) requestBody.get("typeResource");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		
		Resource resource = ResourceFactory.createResource("Reservation.resource.core.model.ResourceImpl", name, typeResource, location);
		Repository.saveObject(resource);
		return resource;
	}

	public Resource createResource(Map<String, Object> requestBody, int id){
		int idResource = id;
		String name = (String) requestBody.get("name");
		String typeResource = (String) requestBody.get("typeResource");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		Resource resource = ResourceFactory.createResource("Reservation.resource.core.model.ResourceImpl",idResource, name, typeResource, location);
		Repository.saveObject(resource);
		return resource;
	}

    public HashMap<String, Object> updateResource(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idResource");
		int id = Integer.parseInt(idStr);
		Resource resource = Repository.getObject(id);
		
		resource.setName((String) requestBody.get("name"));
		resource.setTypeResource((String) requestBody.get("typeResource"));
		resource.setLocation((String) requestBody.get("location"));
		
		Repository.updateObject(resource);
		
		//to do: fix association attributes
		
		return resource.toHashMap();
		
	}

    public HashMap<String, Object> getResource(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idResource"); 
		int id = Integer.parseInt(idStr);
		Resource resource = Repository.getObject(id);
		return resource.toHashMap();
	}

	public HashMap<String, Object> getResourceById(int id){
		List<HashMap<String, Object>> resourceList = getAllResource();
		for (HashMap<String, Object> resource : resourceList){
			int record_id = ((Double) resource.get("idResource")).intValue();
			if (record_id == id){
				return resource;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllResource(){
		List<Resource> List = Repository.getAllObject("resource_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Resource> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteResource(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idResource"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllResource();
	}

}
