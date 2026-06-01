package Reservation.payment.merchant.model;

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

@Entity(name="payment_merchant")
@Table(name="payment_merchant")
public class PaymentImpl extends PaymentDecorator {

	protected String namaMerchant;
	public PaymentImpl() {
        super();
		Random r = new Random();
		this.idPayment = Math.abs(r.nextInt());
        this.objectName = PaymentImpl.class.getName();
    }

	public PaymentImpl(PaymentComponent record, String namaMerchant) {
		super(record, PaymentImpl.class.getName());
		this.namaMerchant = namaMerchant;
		this.objectName = PaymentImpl.class.getName();
	}

	public String getNamaMerchant() {
		return this.namaMerchant;
	}

	public void setNamaMerchant(String namaMerchant) {
		this.namaMerchant = namaMerchant;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idPayment", idPayment);
		map.put("namaMerchant", getNamaMerchant());

        return map;
    }

}
