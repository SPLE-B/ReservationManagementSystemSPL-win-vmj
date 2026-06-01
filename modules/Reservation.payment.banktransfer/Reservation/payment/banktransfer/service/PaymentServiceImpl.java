package Reservation.payment.banktransfer.service;

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
		String namaBankAsal = (String) requestBody.get("namaBankAsal");
		String noRekAsalStr = (String) requestBody.get("noRekAsal");
		int noRekAsal = Integer.parseInt(noRekAsalStr);
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String statusPayment = (String) requestBody.get("statusPayment");
		String metodePayment = (String) requestBody.get("metodePayment");
		Payment paymentbanktransfer = record.createPayment(requestBody);
		Payment paymentbanktransferdeco = PaymentFactory.createPayment("Reservation.payment.banktransfer.model.PaymentImpl", paymentbanktransfer, namaBankAsal, noRekAsal);
		Repository.saveObject(paymentbanktransferdeco);
		return paymentbanktransferdeco;
	}

	public Payment createPayment(Map<String, Object> requestBody, int id){
		Payment savedPayment = Repository.getObject(id);
		String namaBankAsal = (String) requestBody.get("namaBankAsal");
		String noRekAsalStr = (String) requestBody.get("noRekAsal");
		int noRekAsal = Integer.parseInt(noRekAsalStr);
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
		Payment paymentbanktransfer = PaymentFactory.createPayment("Reservation.payment.banktransfer.model.PaymentImpl", Payment, namaBankAsal, noRekAsal);
		return paymentbanktransfer;
	}

    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idPayment");
		int id = Integer.parseInt(idStr);
		
		Payment paymentbanktransfer = Repository.getObject(id);
		String idBookingStr = (String) requestBody.get("idBooking");
		paymentbanktransfer.setIdBooking(Integer.parseInt(idBookingStr));
		String amountStr = (String) requestBody.get("amount");
		paymentbanktransfer.setAmount(Integer.parseInt(amountStr));
		paymentbanktransfer.setStatusPayment((String) requestBody.get("statusPayment"));
		paymentbanktransfer.setMetodePayment((String) requestBody.get("metodePayment"));
		Reservation.payment.banktransfer.model.PaymentImpl impl =
			(Reservation.payment.banktransfer.model.PaymentImpl) paymentbanktransfer;
		impl.setNamaBankAsal((String) requestBody.get("namaBankAsal"));
		String noRekAsalStr = (String) requestBody.get("noRekAsal");
		impl.setNoRekAsal(Integer.parseInt(noRekAsalStr));
		
		Repository.updateObject(paymentbanktransfer);
		
		//to do: fix association attributes
		
		return paymentbanktransfer.toHashMap();
	}

	public HashMap<String, Object> getPayment(String idStr){
		int id = Integer.parseInt(idStr);
		Payment paymentbanktransfer = Repository.getObject(id);
		return paymentbanktransfer.toHashMap();
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
		List<Payment> List = Repository.getAllObject("payment_banktransfer");
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
