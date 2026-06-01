package Reservation.cancellation.cancellationpaid.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Reservation.cancellation.core.service.CancellationServiceDecorator;
import Reservation.cancellation.core.model.CancellationImpl;
import Reservation.cancellation.core.service.CancellationServiceComponent;
import Reservation.cancellation.core.model.Cancellation;
import Reservation.cancellation.core.model.CancellationDecorator;
import Reservation.cancellation.CancellationFactory;

public class CancellationServiceImpl extends CancellationServiceDecorator {
    public CancellationServiceImpl (CancellationServiceComponent record) {
        super(record);
    }

	public Cancellation createCancellation(Map<String, Object> requestBody){
		String refundAmountStr = (String) requestBody.get("refundAmount");
		int refundAmount = Integer.parseInt(refundAmountStr);
		String penaltyFeeStr = (String) requestBody.get("penaltyFee");
		int penaltyFee = Integer.parseInt(penaltyFeeStr);
		Cancellation cancellationcancellationpaid = record.createCancellation(requestBody);
		Cancellation cancellationcancellationpaiddeco = CancellationFactory.createCancellation("Reservation.cancellation.cancellationpaid.model.CancellationImpl", cancellationcancellationpaid, refundAmount, penaltyFee);
		Repository.saveObject(cancellationcancellationpaiddeco);
		return cancellationcancellationpaiddeco;
	}

	public Cancellation createCancellation(Map<String, Object> requestBody, int id){
		Cancellation savedCancellation = Repository.getObject(id);
		String refundAmountStr = (String) requestBody.get("refundAmount");
		int refundAmount = Integer.parseInt(refundAmountStr);
		String penaltyFeeStr = (String) requestBody.get("penaltyFee");
		int penaltyFee = Integer.parseInt(penaltyFeeStr);
		int recordCancellationIdCancellation = ((CancellationDecorator) savedCancellation).getIdCancellation();
		Cancellation Cancellation = record.createCancellation(requestBody, recordCancellationIdCancellation);
		Cancellation cancellationcancellationpaid = CancellationFactory.createCancellation("Reservation.cancellation.cancellationpaid.model.CancellationImpl", Cancellation, refundAmount, penaltyFee);
		return cancellationcancellationpaid;
	}

    public HashMap<String, Object> updateCancellation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idCancellation");
		int id = Integer.parseInt(idStr);
		
		Cancellation cancellationcancellationpaid = Repository.getObject(id);
		String idBookingStr = (String) requestBody.get("idBooking");
		cancellationcancellationpaid.setIdBooking(Integer.parseInt(idBookingStr));
		cancellationcancellationpaid.setReason((String) requestBody.get("reason"));
		cancellationcancellationpaid.setCancelledAt((String) requestBody.get("cancelledAt"));
		Reservation.cancellation.cancellationpaid.model.CancellationImpl impl =
			(Reservation.cancellation.cancellationpaid.model.CancellationImpl) cancellationcancellationpaid;
		String refundAmountStr = (String) requestBody.get("refundAmount");
		impl.setRefundAmount(Integer.parseInt(refundAmountStr));
		String penaltyFeeStr = (String) requestBody.get("penaltyFee");
		impl.setPenaltyFee(Integer.parseInt(penaltyFeeStr));
		
		Repository.updateObject(cancellationcancellationpaid);
		
		//to do: fix association attributes
		
		return cancellationcancellationpaid.toHashMap();
	}

	public HashMap<String, Object> getCancellation(String idStr){
		int id = Integer.parseInt(idStr);
		Cancellation cancellationcancellationpaid = Repository.getObject(id);
		return cancellationcancellationpaid.toHashMap();
	}

	public HashMap<String, Object> getCancellationById(int id){
		List<HashMap<String, Object>> cancellationList = getAllCancellation();
		for (HashMap<String, Object> cancellation : cancellationList){
			int cancellation_id = ((Double) cancellation.get("idcancellation")).intValue();
			if (cancellation_id == id){
				return cancellation;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllCancellation(){
		List<Cancellation> List = Repository.getAllObject("cancellation_cancellationpaid");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Cancellation> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCancellation(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idCancellation"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCancellation();
	}

	
}
