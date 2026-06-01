package Reservation.bookingtype.daily.service;

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
		String jumlahHariStr = (String) requestBody.get("jumlahHari");
		int jumlahHari = Integer.parseInt(jumlahHariStr);
		String bookingDate = (String) requestBody.get("bookingDate");
		String statusBooking = (String) requestBody.get("statusBooking");
		String totalPriceStr = (String) requestBody.get("totalPrice");
		int totalPrice = Integer.parseInt(totalPriceStr);
		String createdAt = (String) requestBody.get("createdAt");
		String idResourceStr = (String) requestBody.get("idResource");
		int idResource = Integer.parseInt(idResourceStr);
		BookingType bookingtypedaily = record.createBookingType(requestBody);
		BookingType bookingtypedailydeco = BookingTypeFactory.createBookingType("Reservation.bookingtype.daily.model.BookingTypeImpl", bookingtypedaily, jumlahHari);
		Repository.saveObject(bookingtypedailydeco);
		return bookingtypedailydeco;
	}

	public BookingType createBookingType(Map<String, Object> requestBody, int id){
		BookingType savedBookingType = Repository.getObject(id);
		String jumlahHariStr = (String) requestBody.get("jumlahHari");
		int jumlahHari = Integer.parseInt(jumlahHariStr);
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
		BookingType bookingtypedaily = BookingTypeFactory.createBookingType("Reservation.bookingtype.daily.model.BookingTypeImpl", BookingType, jumlahHari);
		return bookingtypedaily;
	}

    public HashMap<String, Object> updateBookingType(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idBooking");
		int id = Integer.parseInt(idStr);
		
		BookingType bookingtypedaily = Repository.getObject(id);
		bookingtypedaily.setBookingDate((String) requestBody.get("bookingDate"));
		bookingtypedaily.setStatusBooking((String) requestBody.get("statusBooking"));
		String totalPriceStr = (String) requestBody.get("totalPrice");
		bookingtypedaily.setTotalPrice(Integer.parseInt(totalPriceStr));
		bookingtypedaily.setCreatedAt((String) requestBody.get("createdAt"));
		String idResourceStr = (String) requestBody.get("idResource");
		bookingtypedaily.setIdResource(Integer.parseInt(idResourceStr));
		String jumlahHariStr = (String) requestBody.get("jumlahHari");
		((Reservation.bookingtype.daily.model.BookingTypeImpl) bookingtypedaily).setJumlahHari(Integer.parseInt(jumlahHariStr));
		
		Repository.updateObject(bookingtypedaily);
		
		//to do: fix association attributes
		
		return bookingtypedaily.toHashMap();
	}

	public HashMap<String, Object> getBookingType(String idStr){
		int id = Integer.parseInt(idStr);
		BookingType bookingtypedaily = Repository.getObject(id);
		return bookingtypedaily.toHashMap();
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
		List<BookingType> List = Repository.getAllObject("bookingtype_daily");
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
