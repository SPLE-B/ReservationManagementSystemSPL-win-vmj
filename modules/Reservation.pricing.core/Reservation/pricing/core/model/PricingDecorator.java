package Reservation.pricing.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PricingDecorator extends PricingComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PricingComponent record;

	public PricingDecorator () {
		super();
		Random r = new Random();
		this.idPricing = Math.abs(r.nextInt());
	}

	public PricingDecorator (int idPricing, PricingComponent record) {
		this.idPricing =  idPricing;
		this.record = record;
	}
	
	public PricingDecorator (PricingComponent record, String objectName) {
		Random r = new Random();
		this.idPricing = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdPricing() {
		return record.getIdPricing();
	}
	public void setIdPricing(int idPricing) {
		record.setIdPricing(idPricing);
	}
	public int getBasePrice() {
		return record.getBasePrice();
	}
	public void setBasePrice(int basePrice) {
		record.setBasePrice(basePrice);
	}
	public int getIdResource() {
		return record.getIdResource();
	}
	public void setIdResource(int idResource) {
		record.setIdResource(idResource);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
