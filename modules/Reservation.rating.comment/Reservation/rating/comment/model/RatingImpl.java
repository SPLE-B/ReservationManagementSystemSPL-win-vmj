package Reservation.rating.comment.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Reservation.rating.core.model.RatingDecorator;
import Reservation.rating.core.model.Rating;
import Reservation.rating.core.model.RatingComponent;

@Entity(name="rating_comment")
@Table(name="rating_comment")
public class RatingImpl extends RatingDecorator {

	protected String komentar;
	public RatingImpl() {
        super();
		Random r = new Random();
		this.idRating = Math.abs(r.nextInt());
        this.objectName = RatingImpl.class.getName();
    }

	public RatingImpl(RatingComponent record, String komentar) {
		super(record, RatingImpl.class.getName());
		this.komentar = komentar;
		this.objectName = RatingImpl.class.getName();
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idRating", idRating);
		map.put("komentar", getKomentar());

        return map;
    }

}
