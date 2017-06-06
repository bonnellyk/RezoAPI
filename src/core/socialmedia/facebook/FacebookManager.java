package core.socialmedia.facebook;

import core.socialmedia.SocialMediaManager;

public class FacebookManager implements SocialMediaManager {

	@Override
	public void addOrUpdateToken(int userId, String token, String profileId) {
		System.out.println("FACEBOOK MANAGER");
		FacebookTokensDAO.insertOrReplaceToken(userId, token, profileId);
	}	
}
