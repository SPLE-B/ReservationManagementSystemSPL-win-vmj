package Reservation.cancellation.cancellationpaid.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Reservation.cancellation.core.model.CancellationDecorator;
import Reservation.cancellation.core.model.Cancellation;
import Reservation.cancellation.core.model.CancellationComponent;

@Entity(name="cancellation_cancellationpaid")
@Table(name="cancellation_cancellationpaid")
public class CancellationImpl extends CancellationDecorator {

	protected int refundAmount;
	protected int penaltyFee;
	public CancellationImpl() {
        super();
		Random r = new Random();
		this.idCancellation = Math.abs(r.nextInt());
        this.objectName = CancellationImpl.class.getName();
    }

	public CancellationImpl(CancellationComponent record, int refundAmount, int penaltyFee) {
		super(record, CancellationImpl.class.getName());
		this.refundAmount = refundAmount;
		this.penaltyFee = penaltyFee;
		this.objectName = CancellationImpl.class.getName();
	}

	public int getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	public int getPenaltyFee() {
		return this.penaltyFee;
	}

	public void setPenaltyFee(int penaltyFee) {
		this.penaltyFee = penaltyFee;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idCancellation", idCancellation);
		map.put("refundAmount", getRefundAmount());
		map.put("penaltyFee", getPenaltyFee());

        return map;
    }

}
