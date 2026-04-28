package Reservation.payment.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PaymentDecorator extends PaymentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PaymentComponent record;

	public PaymentDecorator () {
		super();
		Random r = new Random();
		this.idPayment = Math.abs(r.nextInt());
	}

	public PaymentDecorator (int idPayment, PaymentComponent record) {
		this.idPayment =  idPayment;
		this.record = record;
	}
	
	public PaymentDecorator (PaymentComponent record, String objectName) {
		Random r = new Random();
		this.idPayment = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdPayment() {
		return record.getIdPayment();
	}
	public void setIdPayment(int idPayment) {
		record.setIdPayment(idPayment);
	}
	public int getIdBooking() {
		return record.getIdBooking();
	}
	public void setIdBooking(int idBooking) {
		record.setIdBooking(idBooking);
	}
	public int getAmount() {
		return record.getAmount();
	}
	public void setAmount(int amount) {
		record.setAmount(amount);
	}
	public String getStatusPayment() {
		return record.getStatusPayment();
	}
	public void setStatusPayment(String statusPayment) {
		record.setStatusPayment(statusPayment);
	}
	public String getMetodePayment() {
		return record.getMetodePayment();
	}
	public void setMetodePayment(String metodePayment) {
		record.setMetodePayment(metodePayment);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
