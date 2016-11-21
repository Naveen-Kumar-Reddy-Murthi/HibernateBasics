package org.mnr.hibernate.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ORDER_DATE")
	private Date orderDate;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ORDER_HISTORY",
			   joinColumns=@JoinColumn(name="ORDER_ID"),
			   inverseJoinColumns=@JoinColumn(name="CUSTOMER_ID"))
	private Collection<Customer> customers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", customers=");
		builder.append(customers);
		builder.append("]");
		return builder.toString();
	}
	
	
}
