package Reservation.pricing.core.model;

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
@Table(name="pricing_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PricingComponent implements Pricing{
	@Id
	protected int idPricing; 
	protected int basePrice;
	protected String objectName = PricingComponent.class.getName();

	public PricingComponent() {

	} 

	public PricingComponent(
        int idPricing, int basePrice, int idResource
    ) {
        this.idPricing = idPricing;
        this.basePrice = basePrice;
        this.idResource = idResource;
    }

	public int getIdPricing() {
		return this.idPricing;
	}

	public void setIdPricing(int idPricing) {
		this.idPricing = idPricing;
	}
	public int getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public int getIdResource() {
		return this.idResource;
	}

	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idPricing='" + getIdPricing() + "'" +
            " basePrice='" + getBasePrice() + "'" +
            " idResource='" + getIdResource() + "'" +
            "}";
    }
	
}
