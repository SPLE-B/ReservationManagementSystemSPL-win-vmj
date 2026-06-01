package Reservation.bookingtype.sessionbased.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Reservation.bookingtype.core.model.BookingTypeDecorator;
import Reservation.bookingtype.core.model.BookingType;
import Reservation.bookingtype.core.model.BookingTypeComponent;

@Entity(name="bookingtype_sessionbased")
@Table(name="bookingtype_sessionbased")
public class BookingTypeImpl extends BookingTypeDecorator {

	protected String jamMulai;
	protected String jamSelesai;
	public BookingTypeImpl() {
        super();
		Random r = new Random();
		this.idBooking = Math.abs(r.nextInt());
        this.objectName = BookingTypeImpl.class.getName();
    }

	public BookingTypeImpl(BookingTypeComponent record, String jamMulai, String jamSelesai) {
		super(record, BookingTypeImpl.class.getName());
		this.jamMulai = jamMulai;
		this.jamSelesai = jamSelesai;
		this.objectName = BookingTypeImpl.class.getName();
	}

	public String getJamMulai() {
		return this.jamMulai;
	}

	public void setJamMulai(String jamMulai) {
		this.jamMulai = jamMulai;
	}
	public String getJamSelesai() {
		return this.jamSelesai;
	}

	public void setJamSelesai(String jamSelesai) {
		this.jamSelesai = jamSelesai;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idBooking", idBooking);
		map.put("jamMulai", getJamMulai());
		map.put("jamSelesai", getJamSelesai());

        return map;
    }

}
