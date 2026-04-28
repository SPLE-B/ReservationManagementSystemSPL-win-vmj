package Reservation.payment.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.payment.core.model.Payment;

public abstract class PaymentResourceDecorator extends PaymentResourceComponent{
	protected PaymentResourceComponent record;

    public PaymentResourceDecorator(PaymentResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange){
		return record.savePayment(vmjExchange);
	}

    public Payment createPayment(VMJExchange vmjExchange){
		return record.createPayment(vmjExchange);
	}
	
	public Payment createPayment(VMJExchange vmjExchange, int id){
		return record.createPayment(vmjExchange, id);
	}

    public HashMap<String, Object> updatePayment(VMJExchange vmjExchange){
		return record.updatePayment(vmjExchange);
	}

    public HashMap<String, Object> getPayment(VMJExchange vmjExchange){
		return record.getPayment(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
		return record.getAllPayment(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		return record.deletePayment(vmjExchange);
	}

}
