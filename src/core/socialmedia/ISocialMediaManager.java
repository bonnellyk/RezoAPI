package core.socialmedia;

public interface ISocialMediaManager {

	public void addOrUpdateToken(TokenAPI token);
	public TokenAPI getTokenFromUserId(int userId);
}
