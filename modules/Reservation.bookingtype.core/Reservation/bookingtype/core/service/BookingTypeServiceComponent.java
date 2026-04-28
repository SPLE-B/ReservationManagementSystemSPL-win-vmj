package Reservation.bookingtype.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.bookingtype.core.model.BookingType;
//add other required packages

public abstract class BookingTypeServiceComponent implements BookingTypeService{
	protected RepositoryUtil<BookingType> Repository;

    public BookingTypeServiceComponent(){
        this.Repository = new RepositoryUtil<BookingType>(Reservation.bookingtype.core.model.BookingTypeComponent.class);
    }	

    public abstract BookingType createBookingType(Map<String, Object> requestBody);
	public abstract BookingType createBookingType(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateBookingType(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBookingType(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBookingType();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<BookingType> List);
    public abstract List<HashMap<String,Object>> deleteBookingType(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBookingTypeById(int id);

}
