package Reservation.notification.email.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Reservation.notification.core.resource.NotificationResourceDecorator;
import Reservation.notification.core.resource.NotificationResourceComponent;
import Reservation.notification.core.model.Notification;
import Reservation.notification.core.model.NotificationImpl;
import Reservation.notification.core.service.NotificationServiceComponent;
import Reservation.notification.email.service.NotificationServiceImpl;

public class NotificationResourceImpl extends NotificationResourceDecorator {
	protected NotificationServiceComponent recordComponent;
	private NotificationServiceImpl notificationemailServiceImpl;

    public NotificationResourceImpl (NotificationResourceComponent record) {
        super(record);
		this.recordComponent  = new Reservation.notification.core.service.NotificationServiceImpl();
		this.notificationemailServiceImpl = new NotificationServiceImpl(recordComponent);
    }

    
    @Route(url="call/email/save")
    public List<HashMap<String,Object>> saveNotification(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Notification notificationemail = createNotification(vmjExchange);
		return getAllNotification(vmjExchange);
	}

    public Notification createNotification(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notification result = notificationemailServiceImpl.createNotification(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Notification createNotification(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notification result = notificationemailServiceImpl.createNotification(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/email/update")
    public HashMap<String, Object> updateNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return notificationemailServiceImpl.updateNotification(requestBody);
	}

	
    @Route(url="call/email/detail")
    public HashMap<String, Object> getNotification(VMJExchange vmjExchange){
		return record.getNotification(vmjExchange);
	}

	
    @Route(url="call/email/list")
    public List<HashMap<String,Object>> getAllNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return notificationemailServiceImpl.getAllNotification();
	}

    public List<HashMap<String,Object>> transformNotificationListToHashMap(List<Notification> NotificationEmailList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < NotificationEmailList.size(); i++) {
            resultList.add(NotificationEmailList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/email/delete")
    public List<HashMap<String,Object>> deleteNotification(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return notificationemailServiceImpl.deleteNotification(requestBody);
	}

	
}
