package Reservation.notification.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="notification_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class NotificationComponent implements Notification{
	@Id
	protected int idNotification; 
	protected String message;
	protected int typeMessage;
	protected String statusMessage;
	protected String objectName = NotificationComponent.class.getName();

	public NotificationComponent() {

	} 

	public NotificationComponent(
        int idNotification, String message, int typeMessage, String statusMessage
    ) {
        this.idNotification = idNotification;
        this.message = message;
        this.typeMessage = typeMessage;
        this.statusMessage = statusMessage;
    }

	public int getIdNotification() {
		return this.idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public int getTypeMessage() {
		return this.typeMessage;
	}

	public void setTypeMessage(int typeMessage) {
		this.typeMessage = typeMessage;
	}
	public String getStatusMessage() {
		return this.statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idNotification='" + getIdNotification() + "'" +
            " message='" + getMessage() + "'" +
            " typeMessage='" + getTypeMessage() + "'" +
            " statusMessage='" + getStatusMessage() + "'" +
            "}";
    }
	
}
