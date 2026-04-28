package Reservation.pricing.core.model;

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


@Entity(name="pricing_impl")
@Table(name="pricing_impl")
public class PricingImpl extends PricingComponent {

	public PricingImpl(int idPricing, int basePrice, int idResource) {
		this.idPricing = idPricing;
		this.basePrice = basePrice;
		this.idResource = idResource;
	}

	public PricingImpl(int basePrice) {
		Random r = new Random();
		this.idPricing = Math.abs(r.nextInt());
		this.basePrice = basePrice;
		this.idResource = idResource;
	}

	public PricingImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> pricingMap = new HashMap<String,Object>();
		pricingMap.put("idPricing",getIdPricing());
		pricingMap.put("basePrice",getBasePrice());
		pricingMap.put("idResource",getIdResource());

        return pricingMap;
    }

}
