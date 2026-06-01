package Reservation.payment.merchant.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Reservation.payment.core.service.PaymentServiceDecorator;
import Reservation.payment.core.model.PaymentImpl;
import Reservation.payment.core.service.PaymentServiceComponent;
import Reservation.payment.core.model.Payment;
import Reservation.payment.core.model.PaymentDecorator;
import Reservation.payment.PaymentFactory;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl (PaymentServiceComponent record) {
        super(record);
    }

 	public Payment createPayment(Map<String, Object> requestBody){
		String namaMerchant = (String) requestBody.get("namaMerchant");
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String statusPayment = (String) requestBody.get("statusPayment");
		String metodePayment = (String) requestBody.get("metodePayment");
		Payment paymentmerchant = record.createPayment(requestBody);
		Payment paymentmerchantdeco = PaymentFactory.createPayment("Reservation.payment.merchant.model.PaymentImpl", paymentmerchant,  namaMerchant);
		Repository.saveObject(paymentmerchantdeco);
		return paymentmerchantdeco;
	}

	public Payment createPayment(Map<String, Object> requestBody, int id){
		Payment savedPayment = Repository.getObject(id);
		String namaMerchant = (String) requestBody.get("namaMerchant");
		String idPaymentStr = (String) requestBody.get("idPayment");
		int idPayment = Integer.parseInt(idPaymentStr);
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String statusPayment = (String) requestBody.get("statusPayment");
		String metodePayment = (String) requestBody.get("metodePayment");
		int recordPaymentIdPayment = ((PaymentDecorator) savedPayment).getIdPayment();
		Payment Payment = record.createPayment(requestBody, recordPaymentIdPayment);
		Payment paymentmerchant = PaymentFactory.createPayment("Reservation.payment.merchant.model.PaymentImpl", Payment, namaMerchant);
		return paymentmerchant;
	}

    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPayment");
		int id = Integer.parseInt(idStr);
		
		Payment paymentmerchant = Repository.getObject(id);
		paymentmerchant = createPayment(requestBody, id);
		
		Repository.updateObject(paymentmerchant);
		paymentmerchant = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return paymentmerchant.toHashMap();
	}

	public HashMap<String, Object> getPayment(String idStr){
		int id = Integer.parseInt(idStr);
		Payment paymentmerchant = Repository.getObject(id);
		return paymentmerchant.toHashMap();
	}

	public HashMap<String, Object> getPaymentById(int id){
		List<HashMap<String, Object>> paymentList = getAllPayment();
		for (HashMap<String, Object> payment : paymentList){
			int payment_id = ((Double) payment.get("idpayment")).intValue();
			if (payment_id == id){
				return payment;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPayment(){
		List<Payment> List = Repository.getAllObject("payment_merchant");
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
