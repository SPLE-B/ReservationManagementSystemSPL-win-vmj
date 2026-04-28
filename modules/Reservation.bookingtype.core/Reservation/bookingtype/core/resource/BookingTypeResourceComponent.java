package Reservation.bookingtype.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.bookingtype.core.model.BookingType;
//add other required packages

public abstract class BookingTypeResourceComponent implements BookingTypeResource{
	
	public BookingTypeResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveBookingType(VMJExchange vmjExchange);
    public abstract BookingType createBookingType(VMJExchange vmjExchange);
	public abstract BookingType createBookingType(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateBookingType(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBookingType(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBookingType(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBookingType(VMJExchange vmjExchange);

}
