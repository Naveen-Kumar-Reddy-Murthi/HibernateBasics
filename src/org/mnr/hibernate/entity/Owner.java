package org.mnr.hibernate.entity;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OWNER_ID")
	private int id;
	
	private String name;
	
	@OneToMany(cascade={CascadeType.ALL},mappedBy="owner")//mappedBy used to map owner_id in the car itself by avoiding the need for 
//	@JoinTable(name="OWNER_CAR_DETAILS",//This annotation creates another table for mapping owner-car
//			   joinColumns=@JoinColumn(name="owner_id"),
//			   inverseJoinColumns=@JoinColumn(name="car_id"))
	private Collection<Car> cars= new HashSet<Car>();

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

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}
}
