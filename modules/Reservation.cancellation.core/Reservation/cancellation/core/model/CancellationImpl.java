package Reservation.cancellation.core.model;

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


@Entity(name="cancellation_impl")
@Table(name="cancellation_impl")
public class CancellationImpl extends CancellationComponent {

	public CancellationImpl(int idCancellation, int idBooking, String reason, String cancelledAt) {
		this.idCancellation = idCancellation;
		this.idBooking = idBooking;
		this.reason = reason;
		this.cancelledAt = cancelledAt;
	}

	public CancellationImpl(String reason, String cancelledAt) {
		Random r = new Random();
		this. = Math.abs(r.nextInt());
		this.idCancellation = idCancellation;
		this.idBooking = idBooking;
		this.reason = reason;
		this.cancelledAt = cancelledAt;
	}

	public CancellationImpl() { }

	public int getIdCancellation() {
		return this.idCancellation;
	}

	public void setIdCancellation(int idCancellation) {
		this.idCancellation = idCancellation;
	}
	public int getIdBooking() {
		return this.idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCancelledAt() {
		return this.cancelledAt;
	}

	public void setCancelledAt(String cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cancellationMap = new HashMap<String,Object>();
		cancellationMap.put("idCancellation",getIdCancellation());
		cancellationMap.put("idBooking",getIdBooking());
		cancellationMap.put("reason",getReason());
		cancellationMap.put("cancelledAt",getCancelledAt());

        return cancellationMap;
    }

}
