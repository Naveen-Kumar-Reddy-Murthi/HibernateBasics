package org.mnr.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAR_ID")
	private int id;
	private String model;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ENGINE_ID")
	@NotFound(action=NotFoundAction.EXCEPTION)
	private Engine engine;
	@ManyToOne//reverse relationship
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [id=");
		builder.append(id);
		builder.append(", model=");
		builder.append(model);
		builder.append(", engine=");
		builder.append(engine);
		builder.append(", owner=");
		builder.append(owner);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
