package Reservation.notification.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Notification {
	    public int getIdNotification();
	    public void setIdNotification(int idNotification);
	    public String getMessage();
	    public void setMessage(String message);
	    public int getTypeMessage();
	    public void setTypeMessage(int typeMessage);
	    public String getStatusMessage();
	    public void setStatusMessage(String statusMessage);
	HashMap<String, Object> toHashMap();
}
