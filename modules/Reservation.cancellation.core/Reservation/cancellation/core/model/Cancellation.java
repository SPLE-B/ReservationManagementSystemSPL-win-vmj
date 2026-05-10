package Reservation.cancellation.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Cancellation {
	    public int getIdCancellation();
	    public void setIdCancellation(int idCancellation);
	    public int getIdBooking();
	    public void setIdBooking(int idBooking);
	    public String getReason();
	    public void setReason(String reason);
	    public String getCancelledAt();
	    public void setCancelledAt(String cancelledAt);
	HashMap<String, Object> toHashMap();
}
