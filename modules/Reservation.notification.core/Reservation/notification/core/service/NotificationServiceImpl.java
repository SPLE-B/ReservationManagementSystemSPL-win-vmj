package Reservation.notification.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.notification.NotificationFactory;
import Reservation.notification.core.model.Notification;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class NotificationServiceImpl extends NotificationServiceComponent{

    public Notification createNotification(Map<String, Object> requestBody){
		String message = (String) requestBody.get("message");
		String typeMessageStr = (String) requestBody.get("typeMessage");
		int typeMessage = Integer.parseInt(typeMessageStr);
		String statusMessage = (String) requestBody.get("statusMessage");
		
		//to do: fix association attributes
		
		Notification notification = NotificationFactory.createNotification("Reservation.notification.core.model.NotificationImpl", message, typeMessage, statusMessage);
		Repository.saveObject(notification);
		return notification;
	}

	public Notification createNotification(Map<String, Object> requestBody, int id){
		int idNotification = id;
		String message = (String) requestBody.get("message");
		String typeMessageStr = (String) requestBody.get("typeMessage");
		int typeMessage = Integer.parseInt(typeMessageStr);
		String statusMessage = (String) requestBody.get("statusMessage");
		
		//to do: fix association attributes
		Notification notification = NotificationFactory.createNotification("Reservation.notification.core.model.NotificationImpl",idNotification, message, typeMessage, statusMessage);
		Repository.saveObject(notification);
		return notification;
	}

    public HashMap<String, Object> updateNotification(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idNotification");
		int id = Integer.parseInt(idStr);
		Notification notification = Repository.getObject(id);
		
		notification.setMessage((String) requestBody.get("message"));
		String typeMessageStr = (String) requestBody.get("typeMessage");
		notification.setTypeMessage(Integer.parseInt(typeMessageStr));
		
		notification.setStatusMessage((String) requestBody.get("statusMessage"));
		
		Repository.updateObject(notification);
		
		//to do: fix association attributes
		
		return notification.toHashMap();
		
	}

    public HashMap<String, Object> getNotification(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idNotification"); 
		int id = Integer.parseInt(idStr);
		Notification notification = Repository.getObject(id);
		return notification.toHashMap();
	}

	public HashMap<String, Object> getNotificationById(int id){
		List<HashMap<String, Object>> notificationList = getAllNotification();
		for (HashMap<String, Object> notification : notificationList){
			int record_id = ((Double) notification.get("idNotification")).intValue();
			if (record_id == id){
				return notification;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllNotification(){
		List<Notification> List = Repository.getAllObject("notification_impl");
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
