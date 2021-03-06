package core.socialmedia.facebook;

import core.socialmedia.ISocialMediaManager;
import core.socialmedia.TokenAPI;

public class FacebookManager implements ISocialMediaManager {

	@Override
	public void addOrUpdateToken(TokenAPI token) {		
		FacebookTokensDAO.insertOrReplaceToken(token);
	}

	@Override
	public TokenAPI getTokenFromUserId(int userId) {
		TokenAPI token = FacebookTokensDAO.getTokenFromUserId(userId);
		return token;
	}	
}
