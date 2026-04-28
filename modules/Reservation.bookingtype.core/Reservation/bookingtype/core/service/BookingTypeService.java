package Reservation.bookingtype.core.service;
import java.util.*;

import Reservation.bookingtype.core.model.BookingType;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface BookingTypeService {
	BookingType createBookingType(Map<String, Object> requestBody);
	HashMap<String, Object> getBookingType(Map<String, Object> requestBody);
    HashMap<String, Object> updateBookingType(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllBookingType();
    List<HashMap<String,Object>> deleteBookingType(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<BookingType> List);
}
