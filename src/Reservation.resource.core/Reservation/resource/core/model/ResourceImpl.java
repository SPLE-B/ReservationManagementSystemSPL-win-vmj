package Reservation.resource.core.model;

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


@Entity(name="resource_impl")
@Table(name="resource_impl")
public class ResourceImpl extends ResourceComponent {

	public ResourceImpl(int idResource, String name, String typeResource, String location) {
		this.idResource = idResource;
		this.name = name;
		this.typeResource = typeResource;
		this.location = location;
	}

	public ResourceImpl(String name, String typeResource, String location) {
		Random r = new Random();
		this.idResource = Math.abs(r.nextInt());
		this.name = name;
		this.typeResource = typeResource;
		this.location = location;
	}

	public ResourceImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> resourceMap = new HashMap<String,Object>();
		resourceMap.put("idResource",getIdResource());
		resourceMap.put("name",getName());
		resourceMap.put("typeResource",getTypeResource());
		resourceMap.put("location",getLocation());

        return resourceMap;
    }

}
