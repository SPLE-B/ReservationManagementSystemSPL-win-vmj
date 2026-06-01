package Reservation.payment.merchant.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Reservation.payment.core.resource.PaymentResourceDecorator;
import Reservation.payment.core.resource.PaymentResourceComponent;
import Reservation.payment.core.model.Payment;
import Reservation.payment.core.model.PaymentImpl;
import Reservation.payment.core.service.PaymentServiceComponent;
import Reservation.payment.merchant.service.PaymentServiceImpl;

public class PaymentResourceImpl extends PaymentResourceDecorator {
	protected PaymentServiceComponent recordComponent;
	private PaymentServiceImpl paymentmerchantServiceImpl;

    public PaymentResourceImpl (PaymentResourceComponent record) {
        super(record);
		this.recordComponent  = new Reservation.payment.core.service.PaymentServiceImpl();
		this.paymentmerchantServiceImpl = new PaymentServiceImpl(recordComponent);
    }

    
    @Route(url="call/merchant/save")
    public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment paymentmerchant = createPayment(vmjExchange);
		return getAllPayment(vmjExchange);
	}

    public Payment createPayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentmerchantServiceImpl.createPayment(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Payment createPayment(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentmerchantServiceImpl.createPayment(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/merchant/update")
    public HashMap<String, Object> updatePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return paymentmerchantServiceImpl.updatePayment(requestBody);
	}

	
    @Route(url="call/merchant/detail")
    public HashMap<String, Object> getPayment(VMJExchange vmjExchange){
		return record.getPayment(vmjExchange);
	}

	
    @Route(url="call/merchant/list")
    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return paymentmerchantServiceImpl.getAllPayment();
	}

    public List<HashMap<String,Object>> transformPaymentListToHashMap(List<Payment> PaymentMerchantList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentMerchantList.size(); i++) {
            resultList.add(PaymentMerchantList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/merchant/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return paymentmerchantServiceImpl.deletePayment(requestBody);
	}

	
}
