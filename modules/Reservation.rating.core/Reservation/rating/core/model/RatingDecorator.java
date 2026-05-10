package Reservation.rating.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class RatingDecorator extends RatingComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected RatingComponent record;

	public RatingDecorator () {
		super();
		Random r = new Random();
		this.idRating = Math.abs(r.nextInt());
	}

	public RatingDecorator (int idRating, RatingComponent record) {
		this.idRating =  idRating;
		this.record = record;
	}
	
	public RatingDecorator (RatingComponent record, String objectName) {
		Random r = new Random();
		this.idRating = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdRating() {
		return record.getIdRating();
	}
	public void setIdRating(int idRating) {
		record.setIdRating(idRating);
	}
	public int getIdResource() {
		return record.getIdResource();
	}
	public void setIdResource(int idResource) {
		record.setIdResource(idResource);
	}
	public int getScore() {
		return record.getScore();
	}
	public void setScore(int score) {
		record.setScore(score);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
