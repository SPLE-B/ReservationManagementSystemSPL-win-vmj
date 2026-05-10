package Reservation.bookingtype.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BookingTypeDecorator extends BookingTypeComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BookingTypeComponent record;

	public BookingTypeDecorator () {
		super();
		Random r = new Random();
		this.idBooking = Math.abs(r.nextInt());
	}

	public BookingTypeDecorator (int idBooking, BookingTypeComponent record) {
		this.idBooking =  idBooking;
		this.record = record;
	}
	
	public BookingTypeDecorator (BookingTypeComponent record, String objectName) {
		Random r = new Random();
		this.idBooking = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdBooking() {
		return record.getIdBooking();
	}
	public void setIdBooking(int idBooking) {
		record.setIdBooking(idBooking);
	}
	public String getBookingDate() {
		return record.getBookingDate();
	}
	public void setBookingDate(String bookingDate) {
		record.setBookingDate(bookingDate);
	}
	public String getStatusBooking() {
		return record.getStatusBooking();
	}
	public void setStatusBooking(String statusBooking) {
		record.setStatusBooking(statusBooking);
	}
	public int getTotalPrice() {
		return record.getTotalPrice();
	}
	public void setTotalPrice(int totalPrice) {
		record.setTotalPrice(totalPrice);
	}
	public String getCreatedAt() {
		return record.getCreatedAt();
	}
	public void setCreatedAt(String createdAt) {
		record.setCreatedAt(createdAt);
	}
	public int getIdResource() {
		return record.getIdResource();
	}
	public void setIdResource(int idResource) {
		record.setIdResource(idResource);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
