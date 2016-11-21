package org.mnr.hibernate.entity;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private Collection<Address>  addressList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Access(AccessType.PROPERTY)
	@ElementCollection(fetch=FetchType.EAGER) 
	@JoinTable      (name="PERSON_ADDRESS",joinColumns=@JoinColumn(name="id"))//JoinTable/CollectionTable can be used. Both will have same properties and same behaviour
//	@CollectionTable(name="PERSON_ADDRESS",joinColumns=@JoinColumn(name="id"))
	@GenericGenerator(name="hilo-gen",strategy= "hilo")
	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator="hilo-gen",type=@Type(type="long"))//by default collection table will not have any id. To specify we need to use this annotation
	//CollectionId only works with index based collections
	public Collection<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", addressList=");  
		builder.append(addressList);
		builder.append("]");
		return builder.toString();   
	}
	
	

}
