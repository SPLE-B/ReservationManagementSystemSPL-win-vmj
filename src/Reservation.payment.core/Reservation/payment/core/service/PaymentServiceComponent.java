package Reservation.payment.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.payment.core.model.Payment;
//add other required packages

public abstract class PaymentServiceComponent implements PaymentService{
	protected RepositoryUtil<Payment> Repository;

    public PaymentServiceComponent(){
        this.Repository = new RepositoryUtil<Payment>(Reservation.payment.core.model.PaymentComponent.class);
    }	

    public abstract Payment createPayment(Map<String, Object> requestBody);
	public abstract Payment createPayment(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updatePayment(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPayment(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPayment();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Payment> List);
    public abstract List<HashMap<String,Object>> deletePayment(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPaymentById(int id);

}
