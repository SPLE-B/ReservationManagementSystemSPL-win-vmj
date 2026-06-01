package Reservation.pricing.dynamic.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Reservation.pricing.core.model.PricingDecorator;
import Reservation.pricing.core.model.Pricing;
import Reservation.pricing.core.model.PricingComponent;

@Entity(name="pricing_dynamic")
@Table(name="pricing_dynamic")
public class PricingImpl extends PricingDecorator {

	private int peakPercentage;
	public PricingImpl() {
        super();
		Random r = new Random();
		this.idPricing = Math.abs(r.nextInt());
        this.objectName = PricingImpl.class.getName();
    }

	public PricingImpl(PricingComponent record, int peakPercentage) {
		super(record, PricingImpl.class.getName());
		this.peakPercentage = peakPercentage;
		this.objectName = PricingImpl.class.getName();
	}

	public int getPeakPercentage() {
		return this.peakPercentage;
	}

	public void setPeakPercentage(int peakPercentage) {
		this.peakPercentage = peakPercentage;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idPricing", idPricing);
		map.put("peakPercentage", getPeakPercentage());

        return map;
    }

}
