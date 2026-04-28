package Reservation.notification.core.service;
import java.util.*;

import Reservation.notification.core.model.Notification;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface NotificationService {
	Notification createNotification(Map<String, Object> requestBody);
	HashMap<String, Object> getNotification(Map<String, Object> requestBody);
    HashMap<String, Object> updateNotification(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllNotification();
    List<HashMap<String,Object>> deleteNotification(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Notification> List);
}
