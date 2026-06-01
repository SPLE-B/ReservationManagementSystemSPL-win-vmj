package Reservation.rating.comment.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Reservation.rating.core.resource.RatingResourceDecorator;
import Reservation.rating.core.resource.RatingResourceComponent;
import Reservation.rating.core.model.Rating;
import Reservation.rating.core.model.RatingImpl;
import Reservation.rating.core.service.RatingServiceComponent;
import Reservation.rating.comment.service.RatingServiceImpl;

public class RatingResourceImpl extends RatingResourceDecorator {
	protected RatingServiceComponent recordComponent;
	private RatingServiceImpl ratingcommentServiceImpl;

    public RatingResourceImpl (RatingResourceComponent record) {
        super(record);
		this.recordComponent  = new Reservation.rating.core.service.RatingServiceImpl();
		this.ratingcommentServiceImpl = new RatingServiceImpl(recordComponent);
    }

    
    @Route(url="call/comment/save")
    public List<HashMap<String,Object>> saveRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Rating ratingcomment = createRating(vmjExchange);
		return getAllRating(vmjExchange);
	}

    public Rating createRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Rating result = ratingcommentServiceImpl.createRating(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Rating createRating(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Rating result = ratingcommentServiceImpl.createRating(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/comment/update")
    public HashMap<String, Object> updateRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return ratingcommentServiceImpl.updateRating(requestBody);
	}

	
    @Route(url="call/comment/detail")
    public HashMap<String, Object> getRating(VMJExchange vmjExchange){
		return record.getRating(vmjExchange);
	}

	
    @Route(url="call/comment/list")
    public List<HashMap<String,Object>> getAllRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return ratingcommentServiceImpl.getAllRating();
	}

    public List<HashMap<String,Object>> transformRatingListToHashMap(List<Rating> RatingCommentList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < RatingCommentList.size(); i++) {
            resultList.add(RatingCommentList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/comment/delete")
    public List<HashMap<String,Object>> deleteRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return ratingcommentServiceImpl.deleteRating(requestBody);
	}

	
}
