// Generated with g9.

package assignment.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "products")
public class Products implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, length = 255)
	private String name;
	@Column(length = 255)
	private String image;
	@Column(nullable = false, precision = 10)
	private int price;
	@Column(name = "created_date", nullable = false)
	private LocalDate createdDate;
	@Column(nullable = false, precision = 10)
	private int available;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;

	@OneToMany(mappedBy = "product")
	List<OrderDetails> orderDetails;

	/** Default constructor. */
	public Products() {
		super();
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
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

	/**
	 * Access method for name.
	 *
	 * @return the current value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 *
	 * @param aName the new value for name
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Access method for image.
	 *
	 * @return the current value of image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Setter method for image.
	 *
	 * @param aImage the new value for image
	 */
	public void setImage(String aImage) {
		image = aImage;
	}

	/**
	 * Access method for price.
	 *
	 * @return the current value of price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Setter method for price.
	 *
	 * @param aPrice the new value for price
	 */
	public void setPrice(int aPrice) {
		price = aPrice;
	}

	/**
	 * Access method for createdDate.
	 *
	 * @return the current value of createdDate
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	/**
	 * Setter method for createdDate.
	 *
	 * @param aCreatedDate the new value for createdDate
	 */
	public void setCreatedDate(LocalDate aCreatedDate) {
		createdDate = aCreatedDate;
	}

	/**
	 * Access method for available.
	 *
	 * @return the current value of available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Setter method for available.
	 *
	 * @param aAvailable the new value for available
	 */
	public void setAvailable(int aAvailable) {
		available = aAvailable;
	}

	public Categories getCategories() {
		return category;
	}

	public void setCategories(Categories category) {
		this.category = category;
	}
}
