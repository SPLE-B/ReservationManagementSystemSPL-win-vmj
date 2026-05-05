package Reservation.bookingtype.core.model;

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
@Table(name="bookingtype_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingTypeComponent implements BookingType{
	@Id
	protected int idBooking;
	protected int idResource; 
	protected String bookingDate;
	protected String statusBooking;
	protected int totalPrice;
	protected String createdAt;
	protected String objectName = BookingTypeComponent.class.getName();

	public BookingTypeComponent() {

	} 

	public BookingTypeComponent(
        int idBooking, String bookingDate, String statusBooking, int totalPrice, String createdAt, int idResource
    ) {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
        this.statusBooking = statusBooking;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.idResource = idResource;
    }

	public int getIdBooking() {
		return this.idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}
	public String getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStatusBooking() {
		return this.statusBooking;
	}

	public void setStatusBooking(String statusBooking) {
		this.statusBooking = statusBooking;
	}
	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getIdResource() {
		return this.idResource;
	}

	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idBooking='" + getIdBooking() + "'" +
            " bookingDate='" + getBookingDate() + "'" +
            " statusBooking='" + getStatusBooking() + "'" +
            " totalPrice='" + getTotalPrice() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " idResource='" + getIdResource() + "'" +
            "}";
    }
	
}
