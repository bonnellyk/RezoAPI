package core.socialmedia.twitter;

import core.socialmedia.ISocialMediaManager;
import core.socialmedia.TokenAPI;
import core.socialmedia.google.GooglePlusTokensDAO;

public class TwitterManager implements ISocialMediaManager {

	@Override
	public void addOrUpdateToken(TokenAPI token) {		
		TwitterTokensDAO.insertOrReplaceToken(token);
	}	
	
	@Override
	public TokenAPI getTokenFromUserId(int userId) {
		TokenAPI token = TwitterTokensDAO.getTokenFromUserId(userId);
		return token;
	}
}