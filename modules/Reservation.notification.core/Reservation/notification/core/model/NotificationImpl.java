package Reservation.notification.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="notification_impl")
@Table(name="notification_impl")
public class NotificationImpl extends NotificationComponent {

	public NotificationImpl(int idNotification, String message, int typeMessage, String statusMessage) {
		this.idNotification = idNotification;
		this.message = message;
		this.typeMessage = typeMessage;
		this.statusMessage = statusMessage;
	}

	public NotificationImpl(String message, int typeMessage, String statusMessage) {
		Random r = new Random();
		this.idNotification = Math.abs(r.nextInt());
		this.message = message;
		this.typeMessage = typeMessage;
		this.statusMessage = statusMessage;
	}

	public NotificationImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> notificationMap = new HashMap<String,Object>();
		notificationMap.put("idNotification",getIdNotification());
		notificationMap.put("message",getMessage());
		notificationMap.put("typeMessage",getTypeMessage());
		notificationMap.put("statusMessage",getStatusMessage());

        return notificationMap;
    }

}
