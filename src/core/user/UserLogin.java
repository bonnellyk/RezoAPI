package core.user;

import java.sql.Timestamp;

public class UserLogin {
	
	enum LoginAPIEnum {
		FACEBOOK,
		GOOGLE,
		LINKEDIN
	}
	private String firstname;
	private String lastname;
	private String email;
	private Timestamp birthday;
	
	private LoginAPIEnum loginAPI;
	private String accessToken;
	private String profileID;
	
	public UserLogin(String firstname, String lastname, String email, Timestamp birthday, LoginAPIEnum loginAPI,
			String accessToken, String profileID) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthday = birthday;
		this.loginAPI = loginAPI;
		this.accessToken = accessToken;
		this.profileID = profileID;
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

	public LoginAPIEnum getLoginAPI() {
		return loginAPI;
	}

	public void setLoginAPI(LoginAPIEnum loginAPI) {
		this.loginAPI = loginAPI;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	
	
	
}
