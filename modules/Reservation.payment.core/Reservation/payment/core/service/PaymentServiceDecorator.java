package Reservation.payment.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.payment.core.model.Payment;

public abstract class PaymentServiceDecorator extends PaymentServiceComponent{
	protected PaymentServiceComponent record;

    public PaymentServiceDecorator(PaymentServiceComponent record) {
        this.record = record;
    }

	public Payment createPayment(Map<String, Object> requestBody){
		return record.createPayment(requestBody);
	}
	
	public Payment createPayment(Map<String, Object> requestBody, int id){
		return record.createPayment(requestBody, id);
	}

	public HashMap<String, Object> getPayment(Map<String, Object> requestBody){
		return record.getPayment(requestBody);
	}

	public List<HashMap<String,Object>> getAllPayment(){
		return record.getAllPayment();
	}

    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody){
		return record.updatePayment(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePayment(Map<String, Object> requestBody){
		return record.deletePayment(requestBody);
	}

	public HashMap<String, Object> getPaymentById(int id){
        return record.getPaymentById(id);
    }

}
