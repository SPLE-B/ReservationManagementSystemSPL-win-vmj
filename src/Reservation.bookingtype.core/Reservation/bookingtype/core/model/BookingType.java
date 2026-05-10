package Reservation.bookingtype.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface BookingType {
	    public int getIdBooking();
	    public void setIdBooking(int idBooking);
	    public String getBookingDate();
	    public void setBookingDate(String bookingDate);
	    public String getStatusBooking();
	    public void setStatusBooking(String statusBooking);
	    public int getTotalPrice();
	    public void setTotalPrice(int totalPrice);
	    public String getCreatedAt();
	    public void setCreatedAt(String createdAt);
	    public int getIdResource();
	    public void setIdResource(int idResource);
	HashMap<String, Object> toHashMap();
}
