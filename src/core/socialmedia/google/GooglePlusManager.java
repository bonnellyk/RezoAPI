package core.socialmedia.google;

import core.socialmedia.ISocialMediaManager;
import core.socialmedia.TokenAPI;

public class GooglePlusManager implements ISocialMediaManager{

	@Override
	public void addOrUpdateToken(TokenAPI token) {
		GooglePlusTokensDAO.insertOrReplaceToken(token);
	}
	
}
