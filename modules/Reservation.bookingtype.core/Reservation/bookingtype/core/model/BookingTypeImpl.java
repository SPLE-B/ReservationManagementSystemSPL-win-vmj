package Reservation.bookingtype.core.model;

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


@Entity(name="bookingtype_impl")
@Table(name="bookingtype_impl")
public class BookingTypeImpl extends BookingTypeComponent {

	public BookingTypeImpl(int idBooking, String bookingDate, String statusBooking, int totalPrice, String createdAt, int idResource) {
		this.idBooking = idBooking;
		this.bookingDate = bookingDate;
		this.statusBooking = statusBooking;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
		this.idResource = idResource;
	}

	public BookingTypeImpl(String bookingDate, String statusBooking, int totalPrice, String createdAt) {
		Random r = new Random();
		this.idBooking = Math.abs(r.nextInt());
		this.bookingDate = bookingDate;
		this.statusBooking = statusBooking;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
		this.idResource = idResource;
	}

	public BookingTypeImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingtypeMap = new HashMap<String,Object>();
		bookingtypeMap.put("idBooking",getIdBooking());
		bookingtypeMap.put("bookingDate",getBookingDate());
		bookingtypeMap.put("statusBooking",getStatusBooking());
		bookingtypeMap.put("totalPrice",getTotalPrice());
		bookingtypeMap.put("createdAt",getCreatedAt());
		bookingtypeMap.put("idResource",getIdResource());

        return bookingtypeMap;
    }

}
