package Reservation.payment.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Payment {
	    public int getIdPayment();
	    public void setIdPayment(int idPayment);
	    public int getIdBooking();
	    public void setIdBooking(int idBooking);
	    public int getAmount();
	    public void setAmount(int amount);
	    public String getStatusPayment();
	    public void setStatusPayment(String statusPayment);
	    public String getMetodePayment();
	    public void setMetodePayment(String metodePayment);
	HashMap<String, Object> toHashMap();
}
