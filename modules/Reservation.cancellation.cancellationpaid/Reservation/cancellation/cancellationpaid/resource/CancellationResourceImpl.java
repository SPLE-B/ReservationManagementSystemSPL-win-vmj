package Reservation.cancellation.cancellationpaid.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Reservation.cancellation.core.resource.CancellationResourceDecorator;
import Reservation.cancellation.core.resource.CancellationResourceComponent;
import Reservation.cancellation.core.model.Cancellation;
import Reservation.cancellation.core.model.CancellationImpl;
import Reservation.cancellation.core.service.CancellationServiceComponent;
import Reservation.cancellation.cancellationpaid.service.CancellationServiceImpl;

public class CancellationResourceImpl extends CancellationResourceDecorator {
	protected CancellationServiceComponent recordComponent;
	private CancellationServiceImpl cancellationcancellationpaidServiceImpl;

    public CancellationResourceImpl (CancellationResourceComponent record, CancellationServiceComponent recordComponent) {
        super(record);
		this.recordComponent = recordComponent;
		this.cancellationcancellationpaidServiceImpl = new CancellationServiceImpl(recordComponent);
    }

    public CancellationResourceImpl (CancellationResourceComponent record) {
        this(record, new Reservation.cancellation.core.service.CancellationServiceImpl());
    }

    
    @Route(url="call/cancellationpaid/save")
    public List<HashMap<String,Object>> saveCancellation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Cancellation cancellationcancellationpaid = createCancellation(vmjExchange);
		return getAllCancellation(vmjExchange);
	}

    public Cancellation createCancellation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Cancellation result = cancellationcancellationpaidServiceImpl.createCancellation(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Cancellation createCancellation(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Cancellation result = cancellationcancellationpaidServiceImpl.createCancellation(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/cancellationpaid/update")
    public HashMap<String, Object> updateCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return cancellationcancellationpaidServiceImpl.updateCancellation(requestBody);
	}

	
    @Route(url="call/cancellationpaid/detail")
    public HashMap<String, Object> getCancellation(VMJExchange vmjExchange){
		return record.getCancellation(vmjExchange);
	}

	
    @Route(url="call/cancellationpaid/list")
    public List<HashMap<String,Object>> getAllCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return cancellationcancellationpaidServiceImpl.getAllCancellation();
	}

    public List<HashMap<String,Object>> transformCancellationListToHashMap(List<Cancellation> CancellationCancellationPaidList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < CancellationCancellationPaidList.size(); i++) {
            resultList.add(CancellationCancellationPaidList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/cancellationpaid/delete")
    public List<HashMap<String,Object>> deleteCancellation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return cancellationcancellationpaidServiceImpl.deleteCancellation(requestBody);
	}

	
}
