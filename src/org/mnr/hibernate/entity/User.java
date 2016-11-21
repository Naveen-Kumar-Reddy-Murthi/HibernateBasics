package org.mnr.hibernate.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TABLE")
public class User {
	private String name;
	@EmbeddedId
	private Login login;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=");
		builder.append(name);
		builder.append(", login=");
		builder.append(login);
		builder.append("]");
		return builder.toString();
	}
	
	

}
