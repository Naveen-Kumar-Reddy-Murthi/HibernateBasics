package org.mnr.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ENGINE_ID")
	private int id;
	private String code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Engine [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}
	
}
