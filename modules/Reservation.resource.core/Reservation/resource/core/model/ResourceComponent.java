package Reservation.resource.core.model;

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
@Table(name="resource_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ResourceComponent implements Resource{
	@Id
	protected int idResource; 
	protected String name;
	protected String typeResource;
	protected String location;
	protected String objectName = ResourceComponent.class.getName();

	public ResourceComponent() {

	} 

	public ResourceComponent(
        int idResource, String name, String typeResource, String location
    ) {
        this.idResource = idResource;
        this.name = name;
        this.typeResource = typeResource;
        this.location = location;
    }

	public int getIdResource() {
		return this.idResource;
	}

	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTypeResource() {
		return this.typeResource;
	}

	public void setTypeResource(String typeResource) {
		this.typeResource = typeResource;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idResource='" + getIdResource() + "'" +
            " name='" + getName() + "'" +
            " typeResource='" + getTypeResource() + "'" +
            " location='" + getLocation() + "'" +
            "}";
    }
	
}
