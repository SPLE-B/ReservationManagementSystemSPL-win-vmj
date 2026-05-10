package Reservation.payment.core.service;
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
import Reservation.payment.PaymentFactory;
import Reservation.payment.core.model.Payment;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class PaymentServiceImpl extends PaymentServiceComponent{

    public Payment createPayment(Map<String, Object> requestBody){
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String statusPayment = (String) requestBody.get("statusPayment");
		String metodePayment = (String) requestBody.get("metodePayment");
		
		//to do: fix association attributes
		
		Payment payment = PaymentFactory.createPayment("Reservation.payment.core.model.PaymentImpl", idBooking, amount, statusPayment, metodePayment);
		Repository.saveObject(payment);
		return payment;
	}

	public Payment createPayment(Map<String, Object> requestBody, int id){
		int idPayment = id;
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String statusPayment = (String) requestBody.get("statusPayment");
		String metodePayment = (String) requestBody.get("metodePayment");
		
		//to do: fix association attributes
		Payment payment = PaymentFactory.createPayment("Reservation.payment.core.model.PaymentImpl",idPayment, idBooking, amount, statusPayment, metodePayment);
		Repository.saveObject(payment);
		return payment;
	}

    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPayment");
		int id = Integer.parseInt(idStr);
		Payment payment = Repository.getObject(id);
		
		String idBookingStr = (String) requestBody.get("idBooking");
		payment.setIdBooking(Integer.parseInt(idBookingStr));
		
		String amountStr = (String) requestBody.get("amount");
		payment.setAmount(Integer.parseInt(amountStr));
		
		payment.setStatusPayment((String) requestBody.get("statusPayment"));
		payment.setMetodePayment((String) requestBody.get("metodePayment"));
		
		Repository.updateObject(payment);
		
		//to do: fix association attributes
		
		return payment.toHashMap();
		
	}

    public HashMap<String, Object> getPayment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPayment"); 
		int id = Integer.parseInt(idStr);
		Payment payment = Repository.getObject(id);
		return payment.toHashMap();
	}

	public HashMap<String, Object> getPaymentById(int id){
		List<HashMap<String, Object>> paymentList = getAllPayment();
		for (HashMap<String, Object> payment : paymentList){
			int record_id = ((Double) payment.get("idPayment")).intValue();
			if (record_id == id){
				return payment;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPayment(){
		List<Payment> List = Repository.getAllObject("payment_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePayment(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idPayment"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPayment();
	}

}
