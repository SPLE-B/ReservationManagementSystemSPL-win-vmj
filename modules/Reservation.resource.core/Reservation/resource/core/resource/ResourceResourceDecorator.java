package Reservation.resource.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.resource.core.model.Resource;

public abstract class ResourceResourceDecorator extends ResourceResourceComponent{
	protected ResourceResourceComponent record;

    public ResourceResourceDecorator(ResourceResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveResource(VMJExchange vmjExchange){
		return record.saveResource(vmjExchange);
	}

    public Resource createResource(VMJExchange vmjExchange){
		return record.createResource(vmjExchange);
	}
	
	public Resource createResource(VMJExchange vmjExchange, int id){
		return record.createResource(vmjExchange, id);
	}

    public HashMap<String, Object> updateResource(VMJExchange vmjExchange){
		return record.updateResource(vmjExchange);
	}

    public HashMap<String, Object> getResource(VMJExchange vmjExchange){
		return record.getResource(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllResource(VMJExchange vmjExchange){
		return record.getAllResource(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteResource(VMJExchange vmjExchange){
		return record.deleteResource(vmjExchange);
	}

}
