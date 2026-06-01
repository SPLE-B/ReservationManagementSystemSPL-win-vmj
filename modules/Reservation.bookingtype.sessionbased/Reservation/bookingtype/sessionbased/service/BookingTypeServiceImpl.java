package Reservation.bookingtype.sessionbased.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Reservation.bookingtype.core.service.BookingTypeServiceDecorator;
import Reservation.bookingtype.core.model.BookingTypeImpl;
import Reservation.bookingtype.core.service.BookingTypeServiceComponent;
import Reservation.bookingtype.core.model.BookingType;
import Reservation.bookingtype.core.model.BookingTypeDecorator;
import Reservation.bookingtype.BookingTypeFactory;

public class BookingTypeServiceImpl extends BookingTypeServiceDecorator {
    public BookingTypeServiceImpl (BookingTypeServiceComponent record) {
        super(record);
    }

 	public BookingType createBookingType(Map<String, Object> requestBody){
		String jamMulai = (String) requestBody.get("jamMulai");
		String jamSelesai = (String) requestBody.get("jamSelesai");
		String bookingDate = (String) requestBody.get("bookingDate");
		String statusBooking = (String) requestBody.get("statusBooking");
		String totalPriceStr = (String) requestBody.get("totalPrice");
		int totalPrice = Integer.parseInt(totalPriceStr);
		String createdAt = (String) requestBody.get("createdAt");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		BookingType bookingtypesessionbased = record.createBookingType(requestBody);
		BookingType bookingtypesessionbaseddeco = BookingTypeFactory.createBookingType("Reservation.bookingtype.sessionbased.model.BookingTypeImpl", bookingtypesessionbased, jamMulai, jamSelesai);
		Repository.saveObject(bookingtypesessionbaseddeco);
		return bookingtypesessionbaseddeco;
	}

	public BookingType createBookingType(Map<String, Object> requestBody, int id){
		BookingType savedBookingType = Repository.getObject(id);
		String jamMulai = (String) requestBody.get("jamMulai");
		String jamSelesai = (String) requestBody.get("jamSelesai");
		String idBookingStr = (String) requestBody.get("idBooking");
		int idBooking = Integer.parseInt(idBookingStr);
		String bookingDate = (String) requestBody.get("bookingDate");
		String statusBooking = (String) requestBody.get("statusBooking");
		String totalPriceStr = (String) requestBody.get("totalPrice");
		int totalPrice = Integer.parseInt(totalPriceStr);
		String createdAt = (String) requestBody.get("createdAt");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		int recordBookingTypeIdBooking = ((BookingTypeDecorator) savedBookingType).getIdBooking();
		BookingType BookingType = record.createBookingType(requestBody, recordBookingTypeIdBooking);
		BookingType bookingtypesessionbased = BookingTypeFactory.createBookingType("Reservation.bookingtype.sessionbased.model.BookingTypeImpl", BookingType, jamMulai, jamSelesai);
		return bookingtypesessionbased;
	}

    public HashMap<String, Object> updateBookingType(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idBooking");
		int id = Integer.parseInt(idStr);
		
		BookingType bookingtypesessionbased = Repository.getObject(id);
		bookingtypesessionbased = createBookingType(requestBody, id);
		
		Repository.updateObject(bookingtypesessionbased);
		bookingtypesessionbased = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return bookingtypesessionbased.toHashMap();
	}

	public HashMap<String, Object> getBookingType(String idStr){
		int id = Integer.parseInt(idStr);
		BookingType bookingtypesessionbased = Repository.getObject(id);
		return bookingtypesessionbased.toHashMap();
	}

	public HashMap<String, Object> getBookingTypeById(int id){
		List<HashMap<String, Object>> bookingtypeList = getAllBookingType();
		for (HashMap<String, Object> bookingtype : bookingtypeList){
			int bookingtype_id = ((Double) bookingtype.get("idbooking")).intValue();
			if (bookingtype_id == id){
				return bookingtype;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllBookingType(){
		List<BookingType> List = Repository.getAllObject("bookingtype_sessionbased");
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
