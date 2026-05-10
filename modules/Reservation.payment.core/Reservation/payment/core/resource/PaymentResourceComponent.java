package Reservation.payment.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.payment.core.model.Payment;
//add other required packages

public abstract class PaymentResourceComponent implements PaymentResource{
	
	public PaymentResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange);
    public abstract Payment createPayment(VMJExchange vmjExchange);
	public abstract Payment createPayment(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updatePayment(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPayment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange);

}
