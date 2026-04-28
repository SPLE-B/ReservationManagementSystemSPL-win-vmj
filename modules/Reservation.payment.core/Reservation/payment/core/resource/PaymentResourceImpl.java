package Reservation.payment.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.payment.PaymentFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Reservation.payment.core.model.Payment;
import Reservation.payment.core.service.PaymentServiceImpl;
//add other required packages


public class PaymentResourceImpl extends PaymentResourceComponent{
	
	private PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();

	
    @Route(url="call/payment/save")
    public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment payment = createPayment(vmjExchange);
		return paymentServiceImpl.getAllPayment();
	}

    public Payment createPayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentServiceImpl.createPayment(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Payment createPayment(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentServiceImpl.createPayment(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/payment/update")
    public HashMap<String, Object> updatePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return paymentServiceImpl.updatePayment(requestBody);
		
	}

	
    @Route(url="call/payment/detail")
    public HashMap<String, Object> getPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return paymentServiceImpl.getPayment(requestBody);
	}

	
    @Route(url="call/payment/list")
    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return paymentServiceImpl.getAllPayment();
	}

	
    @Route(url="call/payment/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return paymentServiceImpl.deletePayment(requestBody);
	}


}
