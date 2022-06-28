// Generated with g9.

package assignment.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "accounts", indexes = { @Index(name = "accounts_username_IX", columnList = "username", unique = true),
		@Index(name = "accounts_email_IX", columnList = "email", unique = true) })
public class Accounts implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(unique = true, nullable = false, length = 255)
	private String username;
	@Column(nullable = false, length = 255)
	private String password;
	@Column(nullable = false, length = 255)
	private String fullname;
	@Column(unique = true, nullable = false, length = 255)
	private String email;
	@Column(length = 255)
	private String photo;
	@Column(nullable = false, precision = 10)
	private int activated;
	@Column(nullable = false, precision = 10)
	private int admin;
	
	@OneToMany(mappedBy = "account")
	List<Orders> orders;
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	/** Default constructor. */
	public Accounts() {
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

	/**
	 * Access method for username.
	 *
	 * @return the current value of username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for username.
	 *
	 * @param aUsername the new value for username
	 */
	public void setUsername(String aUsername) {
		username = aUsername;
	}

	/**
	 * Access method for password.
	 *
	 * @return the current value of password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password.
	 *
	 * @param aPassword the new value for password
	 */
	public void setPassword(String aPassword) {
		password = aPassword;
	}

	/**
	 * Access method for fullname.
	 *
	 * @return the current value of fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Setter method for fullname.
	 *
	 * @param aFullname the new value for fullname
	 */
	public void setFullname(String aFullname) {
		fullname = aFullname;
	}

	/**
	 * Access method for email.
	 *
	 * @return the current value of email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 *
	 * @param aEmail the new value for email
	 */
	public void setEmail(String aEmail) {
		email = aEmail;
	}

	/**
	 * Access method for photo.
	 *
	 * @return the current value of photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter method for photo.
	 *
	 * @param aPhoto the new value for photo
	 */
	public void setPhoto(String aPhoto) {
		photo = aPhoto;
	}

	/**
	 * Access method for activated.
	 *
	 * @return the current value of activated
	 */
	public int getActivated() {
		return activated;
	}

	/**
	 * Setter method for activated.
	 *
	 * @param aActivated the new value for activated
	 */
	public void setActivated(int aActivated) {
		activated = aActivated;
	}

	/**
	 * Access method for admin.
	 *
	 * @return the current value of admin
	 */
	public int getAdmin() {
		return admin;
	}

	/**
	 * Setter method for admin.
	 *
	 * @param aAdmin the new value for admin
	 */
	public void setAdmin(int aAdmin) {
		admin = aAdmin;
	}
}
