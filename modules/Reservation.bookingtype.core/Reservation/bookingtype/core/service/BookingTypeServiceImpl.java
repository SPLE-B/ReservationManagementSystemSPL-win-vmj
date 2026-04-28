package Reservation.bookingtype.core.service;
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
import Reservation.bookingtype.BookingTypeFactory;
import Reservation.bookingtype.core.model.BookingType;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class BookingTypeServiceImpl extends BookingTypeServiceComponent{

    public BookingType createBookingType(Map<String, Object> requestBody){
		String bookingDate = (String) requestBody.get("bookingDate");
		String statusBooking = (String) requestBody.get("statusBooking");
		String totalPriceStr = (String) requestBody.get("totalPrice");
		int totalPrice = Integer.parseInt(totalPriceStr);
		String createdAt = (String) requestBody.get("createdAt");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		
		//to do: fix association attributes
		
		BookingType bookingtype = BookingTypeFactory.createBookingType("Reservation.bookingtype.core.model.BookingTypeImpl", bookingDate, statusBooking, totalPrice, createdAt, idResource);
		Repository.saveObject(bookingtype);
		return bookingtype;
	}

	public BookingType createBookingType(Map<String, Object> requestBody, int id){
		int idBooking = id;
		String bookingDate = (String) requestBody.get("bookingDate");
		String statusBooking = (String) requestBody.get("statusBooking");
		String totalPriceStr = (String) requestBody.get("totalPrice");
		int totalPrice = Integer.parseInt(totalPriceStr);
		String createdAt = (String) requestBody.get("createdAt");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		
		//to do: fix association attributes
		BookingType bookingtype = BookingTypeFactory.createBookingType("Reservation.bookingtype.core.model.BookingTypeImpl",idBooking, bookingDate, statusBooking, totalPrice, createdAt, idResource);
		Repository.saveObject(bookingtype);
		return bookingtype;
	}

    public HashMap<String, Object> updateBookingType(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idBooking");
		int id = Integer.parseInt(idStr);
		BookingType bookingtype = Repository.getObject(id);
		
		bookingtype.setBookingDate((String) requestBody.get("bookingDate"));
		bookingtype.setStatusBooking((String) requestBody.get("statusBooking"));
		String totalPriceStr = (String) requestBody.get("totalPrice");
		bookingtype.setTotalPrice(Integer.parseInt(totalPriceStr));
		
		bookingtype.setCreatedAt((String) requestBody.get("createdAt"));
		String idResourceStr = (String) requestBody.get("idResource");
		bookingtype.setIdResource(Integer.parseInt(idResourceStr));
		
		
		Repository.updateObject(bookingtype);
		
		//to do: fix association attributes
		
		return bookingtype.toHashMap();
		
	}

    public HashMap<String, Object> getBookingType(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idBooking"); 
		int id = Integer.parseInt(idStr);
		BookingType bookingtype = Repository.getObject(id);
		return bookingtype.toHashMap();
	}

	public HashMap<String, Object> getBookingTypeById(int id){
		List<HashMap<String, Object>> bookingtypeList = getAllBookingType();
		for (HashMap<String, Object> bookingtype : bookingtypeList){
			int record_id = ((Double) bookingtype.get("idBooking")).intValue();
			if (record_id == id){
				return bookingtype;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllBookingType(){
		List<BookingType> List = Repository.getAllObject("bookingtype_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BookingType> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBookingType(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idBooking"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBookingType();
	}

}
