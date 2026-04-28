package Reservation.payment.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="payment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment{
	@Id
	protected int idPayment; 
	protected int amount;
	protected String statusPayment;
	protected String metodePayment;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

	} 

	public PaymentComponent(
        int idPayment, int idBooking, int amount, String statusPayment, String metodePayment
    ) {
        this.idPayment = idPayment;
        this.idBooking = idBooking;
        this.amount = amount;
        this.statusPayment = statusPayment;
        this.metodePayment = metodePayment;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idPayment='" + getIdPayment() + "'" +
            " idBooking='" + getIdBooking() + "'" +
            " amount='" + getAmount() + "'" +
            " statusPayment='" + getStatusPayment() + "'" +
            " metodePayment='" + getMetodePayment() + "'" +
            "}";
    }
	
}
