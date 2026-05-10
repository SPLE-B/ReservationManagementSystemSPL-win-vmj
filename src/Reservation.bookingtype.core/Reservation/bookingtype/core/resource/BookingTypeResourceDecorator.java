package Reservation.bookingtype.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import Reservation.bookingtype.core.model.BookingType;

public abstract class BookingTypeResourceDecorator extends BookingTypeResourceComponent{
	protected BookingTypeResourceComponent record;

    public BookingTypeResourceDecorator(BookingTypeResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveBookingType(VMJExchange vmjExchange){
		return record.saveBookingType(vmjExchange);
	}

    public BookingType createBookingType(VMJExchange vmjExchange){
		return record.createBookingType(vmjExchange);
	}
	
	public BookingType createBookingType(VMJExchange vmjExchange, int id){
		return record.createBookingType(vmjExchange, id);
	}

    public HashMap<String, Object> updateBookingType(VMJExchange vmjExchange){
		return record.updateBookingType(vmjExchange);
	}

    public HashMap<String, Object> getBookingType(VMJExchange vmjExchange){
		return record.getBookingType(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllBookingType(VMJExchange vmjExchange){
		return record.getAllBookingType(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteBookingType(VMJExchange vmjExchange){
		return record.deleteBookingType(vmjExchange);
	}

}
