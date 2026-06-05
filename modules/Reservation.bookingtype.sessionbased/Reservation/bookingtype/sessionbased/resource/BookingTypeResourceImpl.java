package Reservation.bookingtype.sessionbased.resource;
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
import Reservation.bookingtype.sessionbased.service.BookingTypeServiceImpl;

public class BookingTypeResourceImpl extends BookingTypeResourceDecorator {
	protected BookingTypeServiceComponent recordComponent;
	private BookingTypeServiceImpl bookingtypesessionbasedServiceImpl;

    public BookingTypeResourceImpl (BookingTypeResourceComponent record, BookingTypeServiceComponent recordComponent) {
        super(record);
		this.recordComponent = recordComponent;
		this.bookingtypesessionbasedServiceImpl = new BookingTypeServiceImpl(recordComponent);
    }

    public BookingTypeResourceImpl (BookingTypeResourceComponent record) {
        this(record, new Reservation.bookingtype.core.service.BookingTypeServiceImpl());
    }

    
    @Route(url="call/sessionbased/save")
    public List<HashMap<String,Object>> saveBookingType(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BookingType bookingtypesessionbased = createBookingType(vmjExchange);
		return getAllBookingType(vmjExchange);
	}

    public BookingType createBookingType(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingType result = bookingtypesessionbasedServiceImpl.createBookingType(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public BookingType createBookingType(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingType result = bookingtypesessionbasedServiceImpl.createBookingType(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/sessionbased/update")
    public HashMap<String, Object> updateBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bookingtypesessionbasedServiceImpl.updateBookingType(requestBody);
	}

	
    @Route(url="call/sessionbased/detail")
    public HashMap<String, Object> getBookingType(VMJExchange vmjExchange){
		return record.getBookingType(vmjExchange);
	}

	
    @Route(url="call/sessionbased/list")
    public List<HashMap<String,Object>> getAllBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return bookingtypesessionbasedServiceImpl.getAllBookingType();
	}

    public List<HashMap<String,Object>> transformBookingTypeListToHashMap(List<BookingType> BookingTypeSessionBasedList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < BookingTypeSessionBasedList.size(); i++) {
            resultList.add(BookingTypeSessionBasedList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/sessionbased/delete")
    public List<HashMap<String,Object>> deleteBookingType(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bookingtypesessionbasedServiceImpl.deleteBookingType(requestBody);
	}

	
}
