package Reservation.resource.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ResourceDecorator extends ResourceComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ResourceComponent record;

	public ResourceDecorator () {
		super();
		Random r = new Random();
		this.idResource = Math.abs(r.nextInt());
	}

	public ResourceDecorator (int idResource, ResourceComponent record) {
		this.idResource =  idResource;
		this.record = record;
	}
	
	public ResourceDecorator (ResourceComponent record, String objectName) {
		Random r = new Random();
		this.idResource = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdResource() {
		return record.getIdResource();
	}
	public void setIdResource(int idResource) {
		record.setIdResource(idResource);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}
	public String getTypeResource() {
		return record.getTypeResource();
	}
	public void setTypeResource(String typeResource) {
		record.setTypeResource(typeResource);
	}
	public String getLocation() {
		return record.getLocation();
	}
	public void setLocation(String location) {
		record.setLocation(location);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
