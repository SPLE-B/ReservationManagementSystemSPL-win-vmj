package Reservation.notification.email.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Reservation.notification.core.service.NotificationServiceDecorator;
import Reservation.notification.core.model.NotificationImpl;
import Reservation.notification.core.service.NotificationServiceComponent;
import Reservation.notification.core.model.Notification;
import Reservation.notification.core.model.NotificationDecorator;
import Reservation.notification.NotificationFactory;

public class NotificationServiceImpl extends NotificationServiceDecorator {
    public NotificationServiceImpl (NotificationServiceComponent record) {
        super(record);
    }

 	public Notification createNotification(Map<String, Object> requestBody){
		String targetEmail = (String) requestBody.get("targetEmail");
		String message = (String) requestBody.get("message");
		String typeMessage = (String) requestBody.get("typeMessage");
		String statusMessage = (String) requestBody.get("statusMessage");
		Notification notificationemail = record.createNotification(requestBody);
		Notification notificationemaildeco = NotificationFactory.createNotification("Reservation.notification.email.model.NotificationImpl", notificationemail,  targetEmail);
		Repository.saveObject(notificationemaildeco);
		return notificationemaildeco;
	}

	public Notification createNotification(Map<String, Object> requestBody, int id){
		Notification savedNotification = Repository.getObject(id);
		String targetEmail = (String) requestBody.get("targetEmail");
		String idNotificationStr = (String) requestBody.get("idNotification");
		int idNotification = Integer.parseInt(idNotificationStr);
		String message = (String) requestBody.get("message");
		String typeMessage = (String) requestBody.get("typeMessage");
		String statusMessage = (String) requestBody.get("statusMessage");
		int recordNotificationIdNotification = ((NotificationDecorator) savedNotification).getIdNotification();
		Notification Notification = record.createNotification(requestBody, recordNotificationIdNotification);
		Notification notificationemail = NotificationFactory.createNotification("Reservation.notification.email.model.NotificationImpl", Notification, targetEmail);
		return notificationemail;
	}

    public HashMap<String, Object> updateNotification(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idNotification");
		int id = Integer.parseInt(idStr);
		
		Notification notificationemail = Repository.getObject(id);
		notificationemail.setMessage((String) requestBody.get("message"));
		notificationemail.setTypeMessage((String) requestBody.get("typeMessage"));
		notificationemail.setStatusMessage((String) requestBody.get("statusMessage"));
		((Reservation.notification.email.model.NotificationImpl) notificationemail).setTargetEmail((String) requestBody.get("targetEmail"));
		
		Repository.updateObject(notificationemail);
		
		//to do: fix association attributes
		
		return notificationemail.toHashMap();
	}

	public HashMap<String, Object> getNotification(String idStr){
		int id = Integer.parseInt(idStr);
		Notification notificationemail = Repository.getObject(id);
		return notificationemail.toHashMap();
	}

	public HashMap<String, Object> getNotificationById(int id){
		List<HashMap<String, Object>> notificationList = getAllNotification();
		for (HashMap<String, Object> notification : notificationList){
			int notification_id = ((Double) notification.get("idnotification")).intValue();
			if (notification_id == id){
				return notification;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllNotification(){
		List<Notification> List = Repository.getAllObject("notification_email");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notification> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteNotification(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idNotification"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllNotification();
	}

	
}
