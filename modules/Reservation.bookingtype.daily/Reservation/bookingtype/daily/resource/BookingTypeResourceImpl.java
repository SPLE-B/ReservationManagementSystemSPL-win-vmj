package Reservation.bookingtype.daily.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Reservation.bookingtype.core.resource.BookingTypeResourceDecorator;
import Reservation.bookingtype.core.resource.BookingTypeResourceComponent;
import Reservation.bookingtype.core.model.BookingType;
import Reservation.bookingtype.core.model.BookingTypeImpl;
import Reservation.bookingtype.core.service.BookingTypeServiceComponent;
import Reservation.bookingtype.daily.service.BookingTypeServiceImpl;

public class BookingTypeResourceImpl extends BookingTypeResourceDecorator {
	protected BookingTypeServiceComponent recordComponent;
	private BookingTypeServiceImpl bookingtypedailyServiceImpl;

    public BookingTypeResourceImpl (BookingTypeResourceComponent record) {
    	super(record);
		this.recordComponent  = new Reservation.bookingtype.core.service.BookingTypeServiceImpl();
		this.bookingtypedailyServiceImpl = new BookingTypeServiceImpl(recordComponent);
    }

    
    @Route(url="call/daily/save")
    public List<HashMap<String,Object>> saveBookingType(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BookingType bookingtypedaily = createBookingType(vmjExchange);
		return getAllBookingType(vmjExchange);
	}

    public BookingType createBookingType(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingType result = bookingtypedailyServiceImpl.createBookingType(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public BookingType createBookingType(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingType result = bookingtypedailyServiceImpl.createBookingType(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/daily/update")
    public HashMap<String, Object> updateBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bookingtypedailyServiceImpl.updateBookingType(requestBody);
	}

	
    @Route(url="call/daily/detail")
    public HashMap<String, Object> getBookingType(VMJExchange vmjExchange){
		return record.getBookingType(vmjExchange);
	}

	
    @Route(url="call/daily/list")
    public List<HashMap<String,Object>> getAllBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return bookingtypedailyServiceImpl.getAllBookingType();
	}

    public List<HashMap<String,Object>> transformBookingTypeListToHashMap(List<BookingType> BookingTypeDailyList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < BookingTypeDailyList.size(); i++) {
            resultList.add(BookingTypeDailyList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/daily/delete")
    public List<HashMap<String,Object>> deleteBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bookingtypedailyServiceImpl.deleteBookingType(requestBody);
	}

	
}
