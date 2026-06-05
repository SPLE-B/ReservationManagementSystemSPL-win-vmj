package Reservation.payment.banktransfer.resource;
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
import Reservation.payment.banktransfer.service.PaymentServiceImpl;

public class PaymentResourceImpl extends PaymentResourceDecorator {
	protected PaymentServiceComponent recordComponent;
	private PaymentServiceImpl paymentbanktransferServiceImpl;

    public PaymentResourceImpl (PaymentResourceComponent record, PaymentServiceComponent recordComponent) {
        super(record);
		this.recordComponent = recordComponent;
		this.paymentbanktransferServiceImpl = new PaymentServiceImpl(recordComponent);
    }

    public PaymentResourceImpl (PaymentResourceComponent record) {
        this(record, new Reservation.payment.core.service.PaymentServiceImpl());
    }

    
    @Route(url="call/banktransfer/save")
    public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment paymentbanktransfer = createPayment(vmjExchange);
		return getAllPayment(vmjExchange);
	}

    public Payment createPayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentbanktransferServiceImpl.createPayment(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Payment createPayment(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentbanktransferServiceImpl.createPayment(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/banktransfer/update")
    public HashMap<String, Object> updatePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return paymentbanktransferServiceImpl.updatePayment(requestBody);
	}

	
    @Route(url="call/banktransfer/detail")
    public HashMap<String, Object> getPayment(VMJExchange vmjExchange){
		return record.getPayment(vmjExchange);
	}

	
    @Route(url="call/banktransfer/list")
    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return paymentbanktransferServiceImpl.getAllPayment();
	}

    public List<HashMap<String,Object>> transformPaymentListToHashMap(List<Payment> PaymentBankTransferList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentBankTransferList.size(); i++) {
            resultList.add(PaymentBankTransferList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/banktransfer/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return paymentbanktransferServiceImpl.deletePayment(requestBody);
	}

	
}
