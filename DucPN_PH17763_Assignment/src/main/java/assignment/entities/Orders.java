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

@Entity(name = "orders")
public class Orders implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "create_date", nullable = false)
	private LocalDate createDate;
	@Column(nullable = false, length = 255)
	private String address;
	@Column(nullable = false, length = 10)
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "order")
	List<OrderDetails> orderDetails;

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	Accounts account;

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	/** Default constructor. */
	public Orders() {
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

	public LocalDate getCreateDate() {
		return createDate;
	}

	/**
	 * Setter method for createDate.
	 *
	 * @param aCreateDate the new value for createDate
	 */
	public void setCreateDate(LocalDate aCreateDate) {
		createDate = aCreateDate;
	}

	/**
	 * Access method for address.
	 *
	 * @return the current value of address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method for address.
	 *
	 * @param aAddress the new value for address
	 */
	public void setAddress(String aAddress) {
		address = aAddress;
	}

}
