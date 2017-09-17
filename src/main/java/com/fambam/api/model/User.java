package com.fambam.api.model;
// Generated 23/08/2017 7:07:03 PM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fambam.api.web.controller.Direction;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "fambamdb")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690932204491614773L;
	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String userName;
	private String password;
	private Gender gender;
	private Boolean enabled;
	private String mobileNumber;
	private String activationKey;
	private String passwordResetKey;
	private Set<Relationship> relationshipsForUserTo = new HashSet<Relationship>(0);
	private Set<Relationship> relationshipsForUserFrom = new HashSet<Relationship>(0);

	public Set<Relationship> getRelationships(Direction direction){
		if(direction.equals(Direction.INBOUND)){
			return this.relationshipsForUserTo;
		} else {
			return this.relationshipsForUserFrom;
		}
	}
	
	public User() {
	}

	public User(long id) {
		this.id = id;
	}

	public User(long id, String firstName,String mobileNumber){
		this.id = id;
		this.firstName = firstName;
		this.mobileNumber = mobileNumber;
	}
	
	public User(long id, String firstName, Gender gender){
		this.id = id;
		this.firstName= firstName;
		this.gender = gender;
	}

	@PrePersist
	public void setDefaults(){
		if(this.gender == null){
			this.gender = Gender.M;
		}
		if(this.enabled == null){
			this.enabled = true;
		}
	}
	
	
	public User(long id, String firstName, String lastName, String middleName, String userName, String password,
			boolean enabled, String mobileNumber, String activationKey, String passwordResetKey,
			Set<Relationship> relationshipsForUserTo, Set<Relationship> relationshipsForUserFrom) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.mobileNumber = mobileNumber;
		this.activationKey = activationKey;
		this.passwordResetKey = passwordResetKey;
		this.relationshipsForUserTo = relationshipsForUserTo;
		this.relationshipsForUserFrom = relationshipsForUserFrom;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "middle_name", length = 45)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "user_name", length = 45, unique = true)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 44)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Column(name = "enabled")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "mobile_number", length = 14)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "activation_key", length = 45)
	public String getActivationKey() {
		return this.activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	@Column(name = "password_reset_key", length = 45)
	public String getPasswordResetKey() {
		return this.passwordResetKey;
	}

	public void setPasswordResetKey(String passwordResetKey) {
		this.passwordResetKey = passwordResetKey;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByUserTo")
	public Set<Relationship> getRelationshipsForUserTo() {
		return this.relationshipsForUserTo;
	}

	public void setRelationshipsForUserTo(Set<Relationship> relationshipsForUserTo) {
		this.relationshipsForUserTo = relationshipsForUserTo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByUserFrom")
	public Set<Relationship> getRelationshipsForUserFrom() {
		return this.relationshipsForUserFrom;
	}

	public void setRelationshipsForUserFrom(Set<Relationship> relationshipsForUserFrom) {
		this.relationshipsForUserFrom = relationshipsForUserFrom;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", mobileNumber="
				+ mobileNumber + ", activationKey=" + activationKey + ", passwordResetKey=" + passwordResetKey
				+ ", relationshipsForUserTo=" + relationshipsForUserTo + ", relationshipsForUserFrom="
				+ relationshipsForUserFrom + "]";
	}

	
//	public UserBuilder getBuilder(){
//		return new UserBuilder();
//	}
//	
//	
//	
//	//Creational - builder design pattern
//	private static class UserBuilder{
//		
//		private UserBuilder builder = new UserBuilder();
//		private User user = new User();
//		
//		public UserBuilder id(long id){
//			user.setId(id);
//			return builder;
//		}
//		
//		public UserBuilder firstName(String firstName){
//			user.setFirstName(firstName);
//			return builder;
//		}
//		
//		public UserBuilder lastName(String lastName){
//			user.setLastName(lastName);
//			return builder;
//		}
//		
//		public User build(){
//			return user;
//		}
//	}
//	
//	User user = new User().getBuilder()
//			.id(1)
//			.firstName("Aashwin")
//			.lastName("Gaur")
//			.build();
//	
//	
}
