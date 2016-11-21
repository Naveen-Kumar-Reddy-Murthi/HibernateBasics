package org.mnr.hibernate.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="FOUR-WHEELER")//Needed only for SINGLE_TABLE strategy
public class FourWheeler extends Vehicle {
	
	private String steeringModel;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FourWheeler [steeringModel=");
		builder.append(steeringModel);
		builder.append("]");
		return builder.toString();
	}

	public String getSteeringModel() {
		return steeringModel;
	}

	public void setSteeringModel(String steeringModel) {
		this.steeringModel = steeringModel;
	}
	
	

}
