package Reservation.bookingtype.daily.model;

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

@Entity(name="bookingtype_daily")
@Table(name="bookingtype_daily")
public class BookingTypeImpl extends BookingTypeDecorator {

	protected int jumlahHari;
	public BookingTypeImpl() {
        super();
		Random r = new Random();
		this.idBooking = Math.abs(r.nextInt());
        this.objectName = BookingTypeImpl.class.getName();
    }

	public BookingTypeImpl(BookingTypeComponent record, int jumlahHari) {
		super(record, BookingTypeImpl.class.getName());
		this.jumlahHari = jumlahHari;
		this.objectName = BookingTypeImpl.class.getName();
	}

	public int getJumlahHari() {
		return this.jumlahHari;
	}

	public void setJumlahHari(int jumlahHari) {
		this.jumlahHari = jumlahHari;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idBooking", idBooking);
		map.put("jumlahHari", getJumlahHari());

        return map;
    }

}
