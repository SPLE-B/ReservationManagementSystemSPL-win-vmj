package Reservation.cancellation.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.cancellation.CancellationFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Reservation.cancellation.core.model.Cancellation;
import Reservation.cancellation.core.service.CancellationServiceImpl;
//add other required packages


public class CancellationResourceImpl extends CancellationResourceComponent{
	
	private CancellationServiceImpl cancellationServiceImpl = new CancellationServiceImpl();

	
    @Route(url="call/cancellation/save")
    public List<HashMap<String,Object>> saveCancellation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Cancellation cancellation = createCancellation(vmjExchange);
		return cancellationServiceImpl.getAllCancellation();
	}

    public Cancellation createCancellation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Cancellation result = cancellationServiceImpl.createCancellation(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Cancellation createCancellation(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Cancellation result = cancellationServiceImpl.createCancellation(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/cancellation/update")
    public HashMap<String, Object> updateCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return cancellationServiceImpl.updateCancellation(requestBody);
		
	}

	
    @Route(url="call/cancellation/detail")
    public HashMap<String, Object> getCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return cancellationServiceImpl.getCancellation(requestBody);
	}

	
    @Route(url="call/cancellation/list")
    public List<HashMap<String,Object>> getAllCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cancellationServiceImpl.getAllCancellation();
	}

	
    @Route(url="call/cancellation/delete")
    public List<HashMap<String,Object>> deleteCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return cancellationServiceImpl.deleteCancellation(requestBody);
	}


}
