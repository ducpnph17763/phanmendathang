// Generated with g9.

package assignment.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name = "order_details")
public class OrderDetails implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, precision = 12)
	private float price;
	@Column(nullable = false, precision = 10)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_id")
	Products product;

	@ManyToOne
	@JoinColumn(name = "order_id")
	Orders order;

	/** Default constructor. */
	public OrderDetails() {
		super();
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public float getPrice() {
		return price;
	}

	/**
	 * Setter method for price.
	 *
	 * @param aPrice the new value for price
	 */
	public void setPrice(float aPrice) {
		price = aPrice;
	}

	/**
	 * Access method for quantity.
	 *
	 * @return the current value of quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method for quantity.
	 *
	 * @param aQuantity the new value for quantity
	 */
	public void setQuantity(int aQuantity) {
		quantity = aQuantity;
	}
}
