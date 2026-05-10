package Reservation.cancellation.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CancellationDecorator extends CancellationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CancellationComponent record;

	public CancellationDecorator () {
		super();
		Random r = new Random();
		this.idCancellation = Math.abs(r.nextInt());
	}

	public CancellationDecorator (int idCancellation, CancellationComponent record) {
		this.idCancellation = idCancellation;
		this.record = record;
	}
	
	public CancellationDecorator (CancellationComponent record, String objectName) {
		Random r = new Random();
		this.idCancellation = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdCancellation() {
		return record.getIdCancellation();
	}
	public void setIdCancellation(int idCancellation) {
		record.setIdCancellation(idCancellation);
	}
	public int getIdBooking() {
		return record.getIdBooking();
	}
	public void setIdBooking(int idBooking) {
		record.setIdBooking(idBooking);
	}
	public String getReason() {
		return record.getReason();
	}
	public void setReason(String reason) {
		record.setReason(reason);
	}
	public String getCancelledAt() {
		return record.getCancelledAt();
	}
	public void setCancelledAt(String cancelledAt) {
		record.setCancelledAt(cancelledAt);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
