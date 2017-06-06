package core.user;

import java.sql.Timestamp;
import java.util.Date;

public class User {

	private String firstname;
	private String lastname;
	private String email;
	private Timestamp birthday;	
	private Timestamp creationDate;

	public User() {

	}

	public User(String firstname, String lastname, String email, Timestamp birthday, Timestamp creationDate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;	
		this.email = email;
		this.creationDate = creationDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}


	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
