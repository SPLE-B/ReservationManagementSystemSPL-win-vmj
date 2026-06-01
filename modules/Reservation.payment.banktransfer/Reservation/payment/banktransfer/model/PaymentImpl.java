package Reservation.payment.banktransfer.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Reservation.payment.core.model.PaymentDecorator;
import Reservation.payment.core.model.Payment;
import Reservation.payment.core.model.PaymentComponent;

@Entity(name="payment_banktransfer")
@Table(name="payment_banktransfer")
public class PaymentImpl extends PaymentDecorator {

	protected String namaBankAsal;
	protected int noRekAsal;
	public PaymentImpl() {
        super();
		Random r = new Random();
		this.idPayment = Math.abs(r.nextInt());
        this.objectName = PaymentImpl.class.getName();
    }

	public PaymentImpl(PaymentComponent record, String namaBankAsal, int noRekAsal) {
		super(record, PaymentImpl.class.getName());
		this.namaBankAsal = namaBankAsal;
		this.noRekAsal = noRekAsal;
		this.objectName = PaymentImpl.class.getName();
	}

	public String getNamaBankAsal() {
		return this.namaBankAsal;
	}

	public void setNamaBankAsal(String namaBankAsal) {
		this.namaBankAsal = namaBankAsal;
	}
	public int getNoRekAsal() {
		return this.noRekAsal;
	}

	public void setNoRekAsal(int noRekAsal) {
		this.noRekAsal = noRekAsal;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idPayment", idPayment);
		map.put("namaBankAsal", getNamaBankAsal());
		map.put("noRekAsal", getNoRekAsal());

        return map;
    }

}
