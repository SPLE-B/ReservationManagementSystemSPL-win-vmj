package Reservation.bookingtype.core.resource;
import java.util.*;

import Reservation.bookingtype.core.model.BookingType;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface BookingTypeResource {
    List<HashMap<String,Object>> saveBookingType(VMJExchange vmjExchange);
    HashMap<String, Object> updateBookingType(VMJExchange vmjExchange);
    HashMap<String, Object> getBookingType(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBookingType(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBookingType(VMJExchange vmjExchange);
}
