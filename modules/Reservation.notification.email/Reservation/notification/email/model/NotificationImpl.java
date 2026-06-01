package Reservation.notification.email.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Reservation.notification.core.model.NotificationDecorator;
import Reservation.notification.core.model.Notification;
import Reservation.notification.core.model.NotificationComponent;

@Entity(name="notification_email")
@Table(name="notification_email")
public class NotificationImpl extends NotificationDecorator {

	protected String targetEmail;
	public NotificationImpl() {
        super();
		Random r = new Random();
		this.idNotification = Math.abs(r.nextInt());
        this.objectName = NotificationImpl.class.getName();
    }

	public NotificationImpl(NotificationComponent record, String targetEmail) {
		super(record, NotificationImpl.class.getName());
		this.targetEmail = targetEmail;
		this.objectName = NotificationImpl.class.getName();
	}

	public String getTargetEmail() {
		return this.targetEmail;
	}

	public void setTargetEmail(String targetEmail) {
		this.targetEmail = targetEmail;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idNotification", idNotification);
		map.put("targetEmail", getTargetEmail());

        return map;
    }

}
