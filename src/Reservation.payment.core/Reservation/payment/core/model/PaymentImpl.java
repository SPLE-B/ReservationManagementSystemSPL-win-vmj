package Reservation.payment.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="payment_impl")
@Table(name="payment_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(int idPayment, int idBooking, int amount, String statusPayment, String metodePayment) {
		this.idPayment = idPayment;
		this.idBooking = idBooking;
		this.amount = amount;
		this.statusPayment = statusPayment;
		this.metodePayment = metodePayment;
	}

	public PaymentImpl(int amount, String statusPayment, String metodePayment) {
		Random r = new Random();
		this.idPayment = Math.abs(r.nextInt());
		this.idBooking = idBooking;
		this.amount = amount;
		this.statusPayment = statusPayment;
		this.metodePayment = metodePayment;
	}

	public PaymentImpl() { }

	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
	public int getIdBooking() {
		return this.idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatusPayment() {
		return this.statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}
	public String getMetodePayment() {
		return this.metodePayment;
	}

	public void setMetodePayment(String metodePayment) {
		this.metodePayment = metodePayment;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> paymentMap = new HashMap<String,Object>();
		paymentMap.put("idPayment",getIdPayment());
		paymentMap.put("idBooking",getIdBooking());
		paymentMap.put("amount",getAmount());
		paymentMap.put("statusPayment",getStatusPayment());
		paymentMap.put("metodePayment",getMetodePayment());

        return paymentMap;
    }

}
