package core.socialmedia.google;

import core.socialmedia.ISocialMediaManager;
import core.socialmedia.TokenAPI;
import core.socialmedia.facebook.FacebookTokensDAO;

public class GooglePlusManager implements ISocialMediaManager{

	@Override
	public void addOrUpdateToken(TokenAPI token) {
		GooglePlusTokensDAO.insertOrReplaceToken(token);
	}
	
	@Override
	public TokenAPI getTokenFromUserId(int userId) {
		TokenAPI token = GooglePlusTokensDAO.getTokenFromUserId(userId);
		return token;
	}
}
