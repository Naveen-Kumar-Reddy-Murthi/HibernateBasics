package org.mnr.hibernate.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity//(name="USER_DETAILS") This property changes both entity name as well as table name
@Table(name="USER_DETAILS")//This annotation only changes db table name. Keeps entity name as it is.
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int id;
	@Column(name="USER_NAME")
	@Basic(fetch=FetchType.LAZY)//Basic means, name treated as column, But there's no speciality except for its attributes
	private String name;
	@Temporal(TemporalType.TIMESTAMP)//tells how date to be stored in db. date/time/timestamp
	private Date joiningDate;
	//@Lob// tells hibernate it is a large object. If property is string then CLOB. If property is byte array then it is BLOB
	private String description;
	@Transient// tells hibernate not to save it to the db. optionally noNeed can be declared as static or transient
	private String noNeed;
	@Embedded
	@AttributeOverrides(
	{
	 @AttributeOverride(name="hno",column=@Column(name="homeHno")),
	 @AttributeOverride(name="street",column=@Column(name="homeStreet")),
	 @AttributeOverride(name="city",column=@Column(name="homeCity")),
	 @AttributeOverride(name="state",column=@Column(name="homeState")),
	 @AttributeOverride(name="country",column=@Column(name="homeCountry")),
	 @AttributeOverride(name="pincode",column=@Column(name="homePincode"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides(
	{
	 @AttributeOverride(name="hno",column=@Column(name="officeHno")),
	 @AttributeOverride(name="street",column=@Column(name="officeStreet")),
	 @AttributeOverride(name="city",column=@Column(name="officeCity")),
	 @AttributeOverride(name="state",column=@Column(name="officeState")),
	 @AttributeOverride(name="country",column=@Column(name="officeCountry")),
	 @AttributeOverride(name="pincode",column=@Column(name="officePincode"))
	})
	private Address officeAddress;
	
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNoNeed() {
		return noNeed;
	}
	public void setNoNeed(String noNeed) {
		this.noNeed = noNeed;
	}
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
		builder.append("UserDetails [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", joiningDate=");
		builder.append(joiningDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", noNeed=");
		builder.append(noNeed);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
