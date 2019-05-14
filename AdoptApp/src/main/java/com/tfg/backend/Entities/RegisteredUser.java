package com.tfg.backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RegisteredUser")
public class RegisteredUser {

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public enum RoleType {
		USER, SHELTER
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@Column
	private RoleType role;
	@Column
	private String userName;
	@Column
	private String password;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Column
	private String name;
	@Column
	private Long phoneNumber;
	@Column
	private String email;

	// private Byte[] image;
	@Column
	private String address;
	@Column
	private String location;

	public RegisteredUser(String userName, String password, String name, Long phoneNumber, String email, String address,
			String location) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Byte[] getImage() {
//		return image;
//	}

	// public void setImage(Byte[] image) {
//		this.image = image;
	// }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public RegisteredUser() {

	}

	public Long getRegisteredUserId() {
		return Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegisteredUserId(long registeredUserId) {
		Id = registeredUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (int) (Id ^ (Id >>> 32));
		result = (prime * result) + ((address == null) ? 0 : address.hashCode());
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		result = (prime * result) + ((location == null) ? 0 : location.hashCode());
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		result = (prime * result) + ((password == null) ? 0 : password.hashCode());
		result = (prime * result) + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = (prime * result) + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RegisteredUser other = (RegisteredUser) obj;
		if (Id != other.Id) {
			return false;
		}
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

}