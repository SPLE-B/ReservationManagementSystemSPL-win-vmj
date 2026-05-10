package Reservation.notification.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class NotificationDecorator extends NotificationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected NotificationComponent record;

	public NotificationDecorator () {
		super();
		Random r = new Random();
		this.idNotification = Math.abs(r.nextInt());
	}

	public NotificationDecorator (int idNotification, NotificationComponent record) {
		this.idNotification =  idNotification;
		this.record = record;
	}
	
	public NotificationDecorator (NotificationComponent record, String objectName) {
		Random r = new Random();
		this.idNotification = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdNotification() {
		return record.getIdNotification();
	}
	public void setIdNotification(int idNotification) {
		record.setIdNotification(idNotification);
	}
	public String getMessage() {
		return record.getMessage();
	}
	public void setMessage(String message) {
		record.setMessage(message);
	}
	public int getTypeMessage() {
		return record.getTypeMessage();
	}
	public void setTypeMessage(int typeMessage) {
		record.setTypeMessage(typeMessage);
	}
	public String getStatusMessage() {
		return record.getStatusMessage();
	}
	public void setStatusMessage(String statusMessage) {
		record.setStatusMessage(statusMessage);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
