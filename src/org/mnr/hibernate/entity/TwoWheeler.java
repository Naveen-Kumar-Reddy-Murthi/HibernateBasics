package org.mnr.hibernate.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="TWO-WHEELER")//Needed only for SINGLE_TABLE strategy
public class TwoWheeler extends Vehicle {
	
	private String HandleSize;

	public String getHandleSize() {
		return HandleSize;
	}

	public void setHandleSize(String handleSize) {
		HandleSize = handleSize;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TwoWheeler [HandleSize=");
		builder.append(HandleSize);
		builder.append("]");
		return builder.toString();
	}
	
	

}
