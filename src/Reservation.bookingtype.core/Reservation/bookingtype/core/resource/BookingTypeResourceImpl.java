package Reservation.bookingtype.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import Reservation.bookingtype.BookingTypeFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import Reservation.bookingtype.core.model.BookingType;
import Reservation.bookingtype.core.service.BookingTypeServiceImpl;
//add other required packages


public class BookingTypeResourceImpl extends BookingTypeResourceComponent{
	
	private BookingTypeServiceImpl bookingtypeServiceImpl = new BookingTypeServiceImpl();

	
    @Route(url="call/bookingtype/save")
    public List<HashMap<String,Object>> saveBookingType(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BookingType bookingtype = createBookingType(vmjExchange);
		return bookingtypeServiceImpl.getAllBookingType();
	}

    public BookingType createBookingType(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingType result = bookingtypeServiceImpl.createBookingType(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public BookingType createBookingType(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingType result = bookingtypeServiceImpl.createBookingType(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/bookingtype/update")
    public HashMap<String, Object> updateBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bookingtypeServiceImpl.updateBookingType(requestBody);
		
	}

	
    @Route(url="call/bookingtype/detail")
    public HashMap<String, Object> getBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return bookingtypeServiceImpl.getBookingType(requestBody);
	}

	
    @Route(url="call/bookingtype/list")
    public List<HashMap<String,Object>> getAllBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingtypeServiceImpl.getAllBookingType();
	}

	
    @Route(url="call/bookingtype/delete")
    public List<HashMap<String,Object>> deleteBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bookingtypeServiceImpl.deleteBookingType(requestBody);
	}


}
