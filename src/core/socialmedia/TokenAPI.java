package core.socialmedia;

public class TokenAPI {

	private int userId;
	private String accessToken;
	private String profileId;
	
	public TokenAPI(int userId, String accessToken, String profileId) {
		super();
		this.userId = userId;
		this.accessToken = accessToken;
		this.profileId = profileId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
	
}
