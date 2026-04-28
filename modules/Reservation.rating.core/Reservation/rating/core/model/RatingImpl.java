package Reservation.rating.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="rating_impl")
@Table(name="rating_impl")
public class RatingImpl extends RatingComponent {

	public RatingImpl(int idRating, int idResource, int score) {
		this.idRating = idRating;
		this.idResource = idResource;
		this.score = score;
	}

	public RatingImpl(int score) {
		Random r = new Random();
		this.idRating = Math.abs(r.nextInt());
		this.idResource = idResource;
		this.score = score;
	}

	public RatingImpl() { }

	public int getIdRating() {
		return this.idRating;
	}

	public void setIdRating(int idRating) {
		this.idRating = idRating;
	}
	public int getIdResource() {
		return this.idResource;
	}

	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> ratingMap = new HashMap<String,Object>();
		ratingMap.put("idRating",getIdRating());
		ratingMap.put("idResource",getIdResource());
		ratingMap.put("score",getScore());

        return ratingMap;
    }

}
