package Reservation.rating.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="rating_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RatingComponent implements Rating{
	@Id
	protected int idRating; 
	protected int score;
	protected String objectName = RatingComponent.class.getName();

	public RatingComponent() {

	} 

	public RatingComponent(
        int idRating, int idResource, int score
    ) {
        this.idRating = idRating;
        this.idResource = idResource;
        this.score = score;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idRating='" + getIdRating() + "'" +
            " idResource='" + getIdResource() + "'" +
            " score='" + getScore() + "'" +
            "}";
    }
	
}
