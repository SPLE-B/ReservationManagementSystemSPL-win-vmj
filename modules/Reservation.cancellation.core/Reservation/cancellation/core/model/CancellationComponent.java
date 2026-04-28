package Reservation.cancellation.core.model;

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
@Table(name="cancellation_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CancellationComponent implements Cancellation{
	protected String reason;
	protected String cancelledAt;
	protected String objectName = CancellationComponent.class.getName();

	public CancellationComponent() {

	} 

	public CancellationComponent(
        int idCancellation, int idBooking, String reason, String cancelledAt
    ) {
        this.idCancellation = idCancellation;
        this.idBooking = idBooking;
        this.reason = reason;
        this.cancelledAt = cancelledAt;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idCancellation='" + getIdCancellation() + "'" +
            " idBooking='" + getIdBooking() + "'" +
            " reason='" + getReason() + "'" +
            " cancelledAt='" + getCancelledAt() + "'" +
            "}";
    }
	
}
