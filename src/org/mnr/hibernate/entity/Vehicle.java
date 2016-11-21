package org.mnr.hibernate.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)//Each entity will have its own table. Each table will have the properties of their entity class. Additionally id from parent is foriegn key is added in child classes
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//Each entity will have its own table
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//creates only one table, all the properties of super and child classes are added into that table only.
//@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)//Needed only for SINGLE_TABLE strategy
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
