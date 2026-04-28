package Reservation.bookingtype.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.bookingtype.core.model.BookingType;

public abstract class BookingTypeServiceDecorator extends BookingTypeServiceComponent{
	protected BookingTypeServiceComponent record;

    public BookingTypeServiceDecorator(BookingTypeServiceComponent record) {
        this.record = record;
    }

	public BookingType createBookingType(Map<String, Object> requestBody){
		return record.createBookingType(requestBody);
	}
	
	public BookingType createBookingType(Map<String, Object> requestBody, int id){
		return record.createBookingType(requestBody, id);
	}

	public HashMap<String, Object> getBookingType(Map<String, Object> requestBody){
		return record.getBookingType(requestBody);
	}

	public List<HashMap<String,Object>> getAllBookingType(){
		return record.getAllBookingType();
	}

    public HashMap<String, Object> updateBookingType(Map<String, Object> requestBody){
		return record.updateBookingType(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BookingType> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBookingType(Map<String, Object> requestBody){
		return record.deleteBookingType(requestBody);
	}

	public HashMap<String, Object> getBookingTypeById(int id){
        return record.getBookingTypeById(id);
    }

}
